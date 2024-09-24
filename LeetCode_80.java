class Solution {
    public int removeDuplicates(int[] nums) {
        int res = 2;
        for(int i = 2 ; i< nums.length ; i++)
        {
            if(nums[i] != nums[res-2])
            {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
}