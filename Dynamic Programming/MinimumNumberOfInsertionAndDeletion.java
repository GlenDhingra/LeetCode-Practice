class MinimumNumberOfInsertionAndDeletion
{
	public static void main(String args[]){
		char arr1[] = new char[]{'h','e','a','p'};
		char arr2[] = new char[]{'p','e','a'};

		int dp[][] = new int[ arr1.length + 1 ][ arr2.length + 1 ];

		for( int i = 0 ; i <= arr1.length ; i++ ){
			for( int j = 0 ; j <= arr2.length ; j++ ){
				if( i == 0 || j == 0 ){
					dp[i][j] = 0;
				}
				else if( arr1[i-1] == arr2[j-1] ){
					dp[i][j] = Math.max( dp[i-1][j-1] + 1, Math.max( dp[i][j-1], dp[i-1][j] ) );
				}
				else{
					dp[i][j] = Math.max( dp[i][j-1], dp[i-1][j] );
				}
			}
		}
		int longestCommonSubsequence = dp[ dp.length - 1 ][ dp[0].length - 1 ];
		int insertions = arr1.length - longestCommonSubsequence;
		int deletions = arr2.length - longestCommonSubsequence;
		System.out.println(longestCommonSubsequence);
		System.out.println(insertions);
		System.out.println(deletions);
	}
}


/*

h ea p

p ea


insertions =  arr1.length - lcs

deletion = arr2.length - lcs

*/