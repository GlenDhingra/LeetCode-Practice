class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            map.add(new ArrayList<>());
        }
        for( int i = 0 ; i < prerequisites.length ; i++ ){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] indegree = new int[numCourses];
        for( int i = 0 ;i < map.size() ; i++ ){
            ArrayList<Integer> temp = map.get(i);
            for( int j = 0 ; j < temp.size() ; j++ ){
                indegree[temp.get(j)]++;
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0 ; i < indegree.length ; i++ ){
            if(indegree[i] == 0){
                queue.add(i);
                res[index] = i;
                index++;
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ArrayList<Integer> temp = map.get(curr);
            for( int i = 0 ; i < temp.size() ; i++ ){
                indegree[temp.get(i)]--;
                if(indegree[temp.get(i)] == 0){
                    queue.add(temp.get(i));
                    res[index] = temp.get(i);
                    index++;
                }
            }
        }
        for( int i = 0 ; i < indegree.length ; i++ ){
            if( indegree[i] > 0  ){
                return new int[0];
            }
        }
        return res;
    }
}
/*
[1,0][2,0][3,1][3,2]

Make 
[
[1,2]
[3]
[3]
[]
]

indegree[0,1,1,2]

queue[0]
res[]

indegree[0,0,0,2]
queue[1,2]
res[0]

indegree[0,0,0,1]
queue[2]
res[0,1]

indegree[0,0,0,0]
queue[3]
res[0,1, 2]

indegree[0,0,0,0]
queue[]
res[0,1,2,3]
*/