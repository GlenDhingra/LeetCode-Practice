class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        int[][] dp = new int[m][n];
        
        for(int i = 0 ; i < dp.length ; i++){
            dp[i][0] = 1;
        }
        for(int j = 0 ; j < dp[0].length ; j++){
            dp[0][j] = 1;
        }
        
        for(int i = 1 ; i < dp.length ; i++)
        {
            for(int j = 1 ; j < dp[i].length ; j++)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
/*
Dynamic Programming
Each point will have unique paths which are sum of it's up and left
*/