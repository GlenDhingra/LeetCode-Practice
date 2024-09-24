class Solution 
{
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        List<List<Integer>> res = new ArrayList();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        backtrack( res , curr , 0 , graph.length - 1 , graph );    
        return res;
    }
    public void backtrack( List<List<Integer>> res , List<Integer> curr , int i , int target , int[][] graph)
    {
        if( curr.get(curr.size() - 1) == target )
        {
            res.add( new ArrayList(curr) );
            return;
        }
        for( int k = 0 ; k < graph[i].length ; k++ )
        {
            curr.add(graph[i][k]);
            backtrack( res , curr , graph[i][k] , target , graph );
            curr.remove(curr.size() - 1);
        }
    }
}