class RodCutting
{
	public static void main(String args[])
	{
		int length = 8;
		int[] price = new int[]{1,5,8,9,10,17,17,20};

		int[][] dp = new int[length + 1][length + 1];

		for( int i = 0 ; i < dp.length ; i++ ){
			for( int j = 0 ; j < dp[0].length ; j++ ){
				if( i == 0 || j == 0 ){
					dp[i][j] = 0;
				}
				else if( j >= i ){
					dp[i][j] = Math.max( dp[i-1][j], dp[i][ j - i ] + price[i-1] );
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		for( int i = 0 ; i < dp.length ; i++ ){
			for( int j = 0 ; j < dp[0].length ; j++ ){
				System.out.print(dp[i][j] + " ");		
			}
			System.out.println();
		}
	}
}