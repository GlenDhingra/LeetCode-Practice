import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] costToReachNode = new int[n];
        Arrays.fill(costToReachNode, Integer.MAX_VALUE);
        costToReachNode[src] = 0;

        HashMap<Integer, List<Destination>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new Destination(flight[1], flight[2]));
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0, 0});
        
        int minCost = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int currentCost = current[1];
            int stops = current[2]; 

            if (node == dst) {
                minCost = Math.min(minCost, currentCost);
                continue;
            }
            if (stops > k) {
                continue;
            }
            if (map.containsKey(node)) {
                for (Destination destination : map.get(node)) {
                    int nextNode = destination.getDest();
                    int price = destination.getCost();
                    int newCost = currentCost + price;
                    if (newCost < costToReachNode[nextNode]) {
                        costToReachNode[nextNode] = newCost;
                        queue.add(new int[]{nextNode, newCost, stops + 1});
                    }
                }
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}

class Destination {
    int dest, cost;

    public Destination(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public int getDest() {
        return dest;
    }

    public int getCost() {
        return cost;
    }
}
