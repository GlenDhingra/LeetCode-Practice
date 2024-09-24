class Solution 
{
    public List<List<Integer>> findSubsequences(int[] nums) 
    {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(res,curr,0,nums);
        return new ArrayList(res);
        
    }
    public void backtrack( Set<List<Integer>> res, List<Integer> curr,int itr,int[] nums  )
    {
        if( curr.size() > 1 )
        {
            res.add( new ArrayList(curr) );
        }
        for( int i = itr ; i < nums.length ; i++ )
        {
            if( curr.isEmpty() || nums[i] >= curr.get(curr.size()-1))
            {
                curr.add( nums[i] );
                backtrack(res,curr,i+1,nums);
                curr.remove(curr.size()-1);
            }
        }     
    }
}
/*
Backtracking Approach
Using set to avoid duplicate curr's in the final result
*/