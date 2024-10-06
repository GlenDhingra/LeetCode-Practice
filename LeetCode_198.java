class Solution {
    public int rob(int[] nums) {
        if( nums.length == 1 ){
            return nums[0];
        }    
        if( nums.length == 2 ){
            return Math.max(nums[0], nums[1]);
        }
        int i = nums.length-3;
        nums[i] += nums[nums.length-1];
        i--;
        while( i >= 0 ){
            nums[i] += Math.max(nums[i+2], nums[i+3]);
            i--;
            
        }
        return Math.max(nums[0], nums[1]);
    }
}