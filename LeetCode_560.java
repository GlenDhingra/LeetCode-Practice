class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int res = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            sum += nums[i];
            if( map.containsKey(sum-k) ){
                res += map.get(sum-k);
            }
            map.putIfAbsent(sum, 0);
            map.put(sum, map.get(sum)+1);
        }
        return res;
    }
}