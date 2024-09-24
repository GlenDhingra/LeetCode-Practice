class MinimumSubsetSumDifference
{
	public static void main(String args[]){
		int[] arr = new int[]{1,2,7};
		int range = 0;
		for( int i = 0 ; i < arr.length ; i++ ){
			range += arr[i];
		}
		boolean[][] dp = new boolean[ arr.length + 1 ][ range + 1 ];

		for( int i = 0 ; i < dp.length ; i++ ){
			for( int j = 0 ; j < dp[0].length ; j++ ){
				if( j == 0 ){
					dp[i][j] = true;
				}
				else if( i == 0 ){
					dp[i][j] = false;
				}
				else if( j >= arr[i-1] ){
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		int curr = dp.length - 1;
		int min = Integer.MAX_VALUE;
		for( int j = 0 ;  j < dp[0].length / 2 ; j++ ){
			if( dp[curr][j] ){
				min = Math.min( min, range - 2*j );
			}
		}
		System.out.println(min);
	}
}

/*
0 1 2 3 4 5 6 7 8 9 10
T T T T F F F T F F T
*/