class Solution {
    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> store = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for( int i = heights.length - 1 ; i >= 0 ; i-- ){
            if( heights[i] > max ){
                store.add(i);
            }
            max = Math.max(max, heights[i]);
        }
        int res[] = new int[store.size()];
        int index = 0;
        for( int i = store.size() - 1 ; i >= 0 ; i-- ){
            res[index] = store.get(i);
            index++;
        }
        return res;
    }
}