class Solution {
    public int findPeakElement(int[] nums) {
        if( nums.length == 1 ){
            return 0;
        }   
        
        int start = 0;
        int end = nums.length - 1;
        
        while( start < end ){
            int mid = (start+end) / 2;
            int left = (mid-1) < 0 ? Integer.MIN_VALUE : nums[mid-1];
            int right = (mid+1) >= nums.length ? Integer.MIN_VALUE : nums[mid+1];
            if( nums[mid] > left && nums[mid] > right ){
                return mid;
            } 
            else if( nums[mid] > right ){
                end = mid;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }
}