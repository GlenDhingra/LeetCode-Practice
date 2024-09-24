class MinimumDeletionToMakePalindrome
{
	public static void main(String args[]){
		char[] arr1 = new char[]{'a','g','b','c','b','a'};

		//Solution

		char[] arr2 = new char[arr1.length];
		int index = 0;
		for( int i = arr1.length - 1 ; i >=0 ; i-- ){
			arr2[index] = arr1[i];
			
			index++;
			
		}

		int[][] dp = new int[ arr1.length +1][ arr2.length +1];

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
		
		
		int longestCommonSubsequence = dp[dp.length - 1][dp[0].length - 1];
		System.out.println(longestCommonSubsequence);
		int result = arr1.length - longestCommonSubsequence;
		System.out.println(result);
	}
}

/*

agbcba

abcbga


abcba

*/