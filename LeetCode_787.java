class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costToReachNode = new int[n];
        for( int i = 0 ; i < costToReachNode.length ; i++ ){
            costToReachNode[i] = 100001;
        }
        costToReachNode[src] = 0;
        HashMap<Integer, ArrayList<Destination>> map = new HashMap<>();
        for( int i = 0 ; i < flights.length ; i++ ){
            if(!map.containsKey(flights[i][0])){
                map.put(flights[i][0], new ArrayList<Destination>());
            }  
            ArrayList<Destination> temp = map.get(flights[i][0]);
            Destination object = new Destination(flights[i][1], flights[i][2]);
            temp.add(object);
            map.put(flights[i][0], temp);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int count = 0;
        while( !queue.isEmpty() && count <= k){
            int size = queue.size();
            count++;
            int tempCostToReachNode[] = Arrays.copyOf(costToReachNode, costToReachNode.length);
            for( int j = 0 ; j < size ; j++ ){
                int node = queue.poll();
                
                if( map.get(node) == null ){
                    continue;
                }
                ArrayList<Destination> destinations = map.get(node);
                
                for( int i = 0 ; i < destinations.size() ; i++ ){
                    
                    Destination current = destinations.get(i);
                    int dest = current.getDest();
                    
                    int cost = current.getCost();
                    int prevDestCost = tempCostToReachNode[dest];
                    int prevSourceCost = costToReachNode[node];
                    System.out.println(prevDestCost);
                    tempCostToReachNode[dest] = Math.min(prevSourceCost + cost, prevDestCost);
                    System.out.println(node + " > " + dest + " = " + tempCostToReachNode[dest]);
                    queue.add(dest);
                }
            }
            costToReachNode = Arrays.copyOf(tempCostToReachNode, tempCostToReachNode.length);
        }
        return costToReachNode[dst] > 100000 ? -1 : costToReachNode[dst];
    }
}

class Destination{
    int dest, cost;
    public Destination(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
    public void setDest(int dest){
        this.dest = dest;
    }
    public void setCost(int cost){
        this.cost = cost;
    }
    public int getDest(){
        return dest;
    }
    public int getCost(){
        return cost;
    }
}
/*
class
class
hashmap
queue
k=stop, consider least till k
*/