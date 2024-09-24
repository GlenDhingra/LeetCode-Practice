class Knapsack01
{
	public static void main(String args[]){
		int N = 4;
		int[] values = new int[]{3,4,5,6};
		int[] weights = new int[]{2,3,4,5};

		int W = 10;
		int[][] dp = new int[N + 1][W+1];
		
		for( int i = 0 ; i <= N ; i++ ){
			for( int j = 0 ; j <= W ; j++ ){
				if( i == 0 || j == 0 ){
					dp[i][j] = 0;
				}
				else if( weights[i-1] <= j ){
								dp[i][j] = Math.max(
							values[i-1] + dp[i-1][j- weights[i-1]],
							dp[i-1][j]
					);
				}
				else{
					dp[i][j] = dp[i-1][j];
				}

			}
		}

		for( int i = 0 ; i <= values.length ; i++ ){
			for( int j = 0 ; j <= W ; j++ ){
				System.out.print( dp[i][j] + "  " );
			}
			System.out.println();
		}

	}
}
