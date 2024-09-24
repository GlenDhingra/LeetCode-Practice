class Solution {
    public int minPairSum(int[] nums) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = nums.length - 1;
        int max = 0;
        Arrays.sort(nums);
        while( i < j )
        {
            max = Math.max(max,nums[i] + nums[j]);   
            i++;
            j--;
        }
        return max;
    }
}