class Solution 
{
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack( res , curr , n , k, 1 );
        return res;
    }
    public void backtrack( List<List<Integer>> res, List<Integer> curr,int n, int k, int itr)
    {
        if( curr.size() == k )
        {
            res.add( new ArrayList(curr) );
            return;
        }
        for( int i = itr ; i <= n ; i++ )
        {
            curr.add(i);
            backtrack( res , curr , n , k,i+1 );
            curr.remove( curr.size() - 1 );
        }
    }
}
/*
Backtracking Approach
Passing elements in a list till the list size reaches K
Once size == k we remove the last element in the list and replace it with remaining numbers till n
itr will keep track of greater numbers as the smaller number combinations should now repeat themselves.
*/