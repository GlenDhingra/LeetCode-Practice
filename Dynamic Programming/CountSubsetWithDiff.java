class CountSubsetWithDiff
{
	public static void main(String args[]){
		int[] arr = new int[]{1,1,2,3};
		int diff = 1;
		int range = 0;
		for( int i = 0 ; i < arr.length ; i++ ){
			 range += arr[i];
		}
		int[][] dp = new int[ arr.length + 1 ][ range + 1 ];

		for( int i = 0 ; i < dp.length ; i++ ){
			for( int j = 0 ; j < dp[0].length ; j++ ){
				if( j == 0 ){
					dp[i][j] = 1;
				}
				else if( i == 0 ){
					dp[i][j] = 0;
				}
				else if( j >= arr[i-1] ){
					dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
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
		System.out.println( dp[ dp.length - 1 ][ (range+diff) / 2 ] );
	}
}

/*
	sum1 + sum2 = range
	sum1 - sum2 = diff

	sum1 = (range + diff) / 2;

	res = count(sum1)
*/

/*
  0 1 2 3 4 5 6 7
0 1 0 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 2 1 0 0 0 0 0
2 1 2 2 2 1 0 0 0
3 1 2 2 3 3 2 2 1
*/