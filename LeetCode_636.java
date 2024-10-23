class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int buffer = 0;
        Stack<int[]> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for( int i = 0; i < logs.size() ; i++ ){
            String currentString = logs.get(i);
            String[] curr = currentString.split(":");
            if( curr[1].equals("start") ){

                int[] currentExecuted = new int[3];
                currentExecuted[0] = Integer.parseInt(curr[0]);
                currentExecuted[1] = Integer.parseInt(curr[2]);
                currentExecuted[2] = 0;                    
                if( stack.isEmpty() ){
                    stack.push(currentExecuted);
                }
                else{
                    int[] prevExecuted = stack.pop();
                    prevExecuted[2] = currentExecuted[1] - prevExecuted[1] + prevExecuted[2] - 1;
                    stack.push(prevExecuted);
                    stack.push(currentExecuted);
                }
            }
            else{
                int[] currentExecuted = stack.pop();
                int id = currentExecuted[0];
                int endTime = Integer.parseInt(curr[2]);
                currentExecuted[2] = endTime - currentExecuted[1] + currentExecuted[2] + 1;
                map.putIfAbsent(id, 0);
                map.put(id, map.get(id) + currentExecuted[2]);
                if( !stack.isEmpty() ){
                    int[] prevExecuted = stack.pop();
                    prevExecuted[1] = endTime;
                    stack.push(prevExecuted);
                }
            }
        }
        int[] res = new int[n];
        for( int i = 0; i < res.length ; i++ ){
            res[i] = map.get(i);
        }
        return res;
    }
}
/*
[id, start_time, executed_time]

*/