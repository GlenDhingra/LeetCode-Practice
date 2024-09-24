class Solution 
{
    public int minReorder(int n, int[][] connections) 
    {
        HashSet<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList();
        int count = 0;
        set.add(0);
        
        for( int i = 0 ; i < connections.length ; i++ )
        {
            queue.offer(connections[i]);
        }
        
        while( !queue.isEmpty() )
        {
            int[] curr = queue.poll();
            if( set.contains(curr[1]) ) 
                set.add(curr[0]);
            else if( set.contains(curr[0]) )
            {
                set.add(curr[1]);
                count++;
            }
            else queue.offer(curr);
        }
        return count;
    }
}
/*
BFS approach[not the best solution]
Keep track of elements present in the set from the root
if set has the destination then add the Source to the set
*/