class ShortestCommonSuperSequence
{
	public static void main(String args[]){
		char[] arr1 = new char[]{'a','g','g','t','a','b'};
		char[] arr2 = new char[]{'g','x','t','x','a','y','b'};

		int[][] dp = new int[ arr1.length+1 ][ arr2.length+1 ];

		for( int i = 0 ; i <= arr1.length ; i++ ){
			for( int j = 0 ; j <= arr2.length ; j++ ){
				if( i == 0 || j == 0 ){
					dp[i][j] = 0;
				}
				else if( arr1[i-1] == arr2[j-1] ){
					dp[i][j] = Math.max( dp[i-1][j-1] + 1, Math.max( dp[i-1][j], dp[i][j-1] ) );
				}
				else{
					dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
				}
			}
		}
		int longestCommonSubsequence = dp[ dp.length - 1 ][ dp[0].length - 1 ];
		System.out.println(longestCommonSubsequence);
		int shortestCommonSuperSequence = arr1.length + arr2.length - longestCommonSubsequence;
		System.out.println(shortestCommonSuperSequence);
	}
}


/*
agxtxayb

	0	a	g	t	a	b
0	0	0	0	0	0	0	
g	0	0	1	1	1	1	
x	0						
t	0						
x	0						
a	0						
y	0						
b	0						

*/