class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> res = new ArrayList<>();    
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        res.add(new ArrayList<>(curr));
        for( int i = 1 ; i < numRows ; i++ )
        {
            curr.clear();
            for( int j = 0 ; j <= i ; j++ )
            {
                int a = getPrev( res.get(res.size()-1), j-1 );
                int b = getNext( res.get(res.size()-1), j );
                curr.add(a+b);
            }
            res.add(new ArrayList<>(curr));
        }
        return res;
    }
    public int getPrev( List<Integer> prev, int j )
    {
        return j < 0 ? 0 : prev.get(j);
    }
    public int getNext( List<Integer> prev, int j )
    {
        return j >= prev.size() ? 0 : prev.get(j);
    }
    
}