class CountOfSubsetSum
{
	public static void main(String args[])
	{
		int[] arr = new int[]{2,3,5,6,8,10};
		int size = 10;

		int[][] dp = new int[ arr.length + 1 ][ size + 1 ];

		for( int i = 0 ; i < dp.length ; i++ ){
			for( int j = 0 ; j < dp[i].length ; j++ ){
				if( j == 0 ){
					dp[i][j] = 1;
				}
				else if( i == 0 ){
					dp[i][j] = 0;
				}
				else if( j >= arr[i-1] ){
					dp[i][j] = dp[i-1][j] + dp[i-1][ j - arr[i-1] ];
				}
				else{
					dp[i][j] = dp[i-1][j];	
				}
			}
		}
		for( int i = 0 ; i < dp.length ; i++ ){
			for( int j = 0 ;  j < dp[i].length ; j++ ){
				System.out.print( dp[i][j] );				
			}
			System.out.println();
		}

	}
}

/*

   0 1 2 3 4 5 6 7 8 9 10
0  1 0 0 0 0 0 0 0 0 0 0
2  1 0 1 0 0 0 0 0 0 0 0
3  1 0 1 1 0 1 0 0 0 0 0
5  1 0 1 1 0 2 0 0 1 0 1
6  1 0 1 1 0 2 1 1 2 1 1
8  1 0 1 1 0 2 1 1 3 1 2
10 1 0 1 1 0 2 1 1 3 1 3
*/