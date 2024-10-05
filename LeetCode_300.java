class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int max = 0;
        int[] arr = new int[nums.length];
        arr[nums.length-1] = 1;
        int i = nums.length-1;
        while( i >= 0){
            max = 1;
            for( int j = i+1 ; j < nums.length ; j++ ){
                if( nums[i] < nums[j] ){
                    max = Math.max(arr[j]+1, max);
                }
            }
            arr[i] = max;
            res = Math.max(max, res);
            i--;
        } 
        return res;
    }
}