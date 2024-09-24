class Solution 
{
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) 
    {
        List<Integer> res = new ArrayList<>();
        int[] curr = new int[n];
        for( int i = 0 ; i < edges.size() ; i++ )
        {
            curr[edges.get(i).get(1)]++;
        }
        for( int i = 0 ; i < curr.length ; i++ )
        {
            if( curr[i] == 0 )
                res.add(i);
        }
        return res;
    }
}
/*
Create a root array and increment the values of element found at index 1 of each array list in edges
if any index in root has values 0 , add it to the result array
*/
/*
A node which has no incoming edge should be added to the result list as we have no way of reaching that node
except itself
*/