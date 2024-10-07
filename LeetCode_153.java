class Solution {
    public int findMin(int[] nums) {
        if( nums.length == 1 || nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        int i = 0;
        int j = nums.length - 1;
        while( j >= i ){
            int mid = (i + j) / 2;
            if( mid == 0 ){
                i++;
            }
            else if( nums[mid] < nums[mid-1] ){
                return nums[mid];
            }
            else if( nums[mid] > nums[j] ){
                i = mid+1;
            }
            else{
                j = mid - 1;
            }
        }
        return 0;
    }
}