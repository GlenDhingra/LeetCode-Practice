class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for( int i = 0 ; i < numCourses ; i++ ){
            map.add(new ArrayList<Integer>());
        }
        for( int i = 0 ; i < prerequisites.length ; i++ ){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree = new int[numCourses];
        for( int i = 0 ; i < numCourses ; i++ ){
            ArrayList<Integer> curr = map.get(i);
            for( int j = 0 ; j < curr.size() ; j++ ){
                indegree[curr.get(j)]++;
            }
        }       
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0 ; i < indegree.length ; i++ ){
            if( indegree[i] == 0 ){
                queue.add(i);
            }
        }
        while( !queue.isEmpty() ){
            int current = queue.poll();
            for( int i = 0 ; i < map.get(current).size() ; i++ ){
                indegree[map.get(current).get(i)]--;
                if( indegree[map.get(current).get(i)] == 0 ){
                    queue.add(map.get(current).get(i));
                }
            }
        }
        for( int i = 0 ; i < indegree.length ; i++ ){
            if( indegree[i] > 0 ){
                return false;
            }
        }
        return true;
    }
}
