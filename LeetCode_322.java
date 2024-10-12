class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for( int i = 0 ; i < dp.length ; i++ ){
            for( int j = 0 ; j < dp[i].length ; j++ ){
                if( i == 0 ){                    
                    dp[i][j] = Integer.MAX_VALUE;
                }
                else if( j == 0 ){
                    dp[i][j] = 0;
                }
                
                else if( j >= coins[i-1] ){
                    int num = dp[i][j-coins[i-1]];
                    num = num == Integer.MAX_VALUE ? num : num+1;
                    dp[i][j] = Math.min(dp[i-1][j], num);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int res = dp[dp.length-1][dp[0].length-1];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
/*
  0 1 2 3 4 5 6 7 8 9 10 11
0 0 m m m m m m m m m  m  m
1 0 1 2 3 4 5 6 7 8 9 10 11                         
2 0 1 1 2 2 3 3 4 4 5 5  6             
5 0 1 1 2 2 1 2 2 3 3 2  3              

  0 1 2 3
0 0 m m m
2 0 m 1 m
*/