class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for( int i = 0 ; i < nums.length ; i++ ){
            queue.add(nums[i]);
        }
        int res = 0;
        int count = 0;
        int prev = Integer.MAX_VALUE;
        while( !queue.isEmpty() ){
            int current = queue.poll();
            if(current==prev) continue;
            if( prev + 1 == current ){
                count++;
            }
            else{
                count = 1;
            }
            prev = current;
            res = Math.max(count, res);
        }
        return res;
    }
}
