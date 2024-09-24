class Solution {
    public int maximumProduct(int[] nums) 
    {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        
        int res = nums[j] * nums[j-1] * nums[j-2];
        
        res = Math.max( res , nums[i] * nums[i+1] * nums[j] );
        
        return res;
    }
}