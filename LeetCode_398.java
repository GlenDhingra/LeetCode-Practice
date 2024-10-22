class Solution {
    HashMap<Integer, ArrayList<Integer>> map;
    Random rand;
    public Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        for( int i = 0 ; i < nums.length ; i++ ){
            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            ArrayList<Integer> temp = map.get(nums[i]);
            temp.add(i);
            map.put(nums[i], temp);
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> curr = map.get(target);
        int index = rand.nextInt(0, curr.size());
        return curr.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */