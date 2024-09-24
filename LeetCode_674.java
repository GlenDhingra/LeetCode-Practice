class Solution 
{
    public int findLengthOfLCIS(int[] nums) 
    {
        int max = 0;
        int start = 0;
        for( int i = 1 ; i < nums.length ; i++ )
        {
            if(nums[i] <= nums[i-1]){
                max = Math.max(max, i - start);
                start = i;
            }
        }
        max = Math.max(max, nums.length - start);
        return max;
    }
}
/*
Sliding Window Problem
Keep index where increasing substring starts
Update max whenever an increasing substring ends
*/