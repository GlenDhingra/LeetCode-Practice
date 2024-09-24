class Solution 
{
    public int findCircleNum(int[][] isConnected) 
    {
        Set<Integer> traversed = new HashSet<>();
        int count = 0;
        for( int i = 0 ;  i < isConnected.length ; i++ )
        {
            if( !traversed.contains(i) )
            {
                traversed.add(i);
                dfs(isConnected,traversed,i);    
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected,Set<Integer> traversed, int k)
    {
        for( int i = 0 ; i < isConnected[k].length ; i++ )
        {
            if( isConnected[k][i] == 1 && !traversed.contains(i))
            {
                traversed.add(i);
                dfs(isConnected,traversed,i);
            }
        }
    }
}
/*
Depth First Search Approach
Traverse through all the adjacent nodes from point 1 and then add them to a set
Skip elements already in the set as they have been grouped previously and increase count for every new group
*/