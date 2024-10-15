class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for( int i = 1 ; i < nums.length ; i++ ){
            if( nums[i] == 0 ){
                res = Math.max(res, 0);
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
            else{
                int min = Math.min(nums[i] * dp[i-1][0], Math.min(nums[i] * dp[i-1][1], nums[i]));
                int max = Math.max( nums[i] * dp[i-1][1], Math.max(nums[i] * dp[i-1][0], nums[i]) );
                res = Math.max(max, Math.max(min, res));
                dp[i][0] = min;
                dp[i][1] = max;
            }
        }    
        return res;
    }
}
/*
store min, max at each point
multiply both min, max with current and store global max
*/