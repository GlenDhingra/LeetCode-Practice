class SubsetSum
{
	public static void main(String args[]){
		int[] values = new int[]{2,3,7,8,10};
		int target = 11;

		boolean[][] dp = new boolean[values.length + 1][target + 1];
		for( int i = 0 ; i < dp.length ; i++ ){
			for( int j = 0 ; j < dp[0].length ; j++ ){
				if( j == 0 ){
					dp[i][j] = true;
				}
				else if( i == 0 ){
					dp[i][j] = false;
				}
				else if( values[i-1] <= j ){
					dp[i][j] = dp[i-1][j - values[i-1]] || dp[i-1][j];	
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);
	}
}