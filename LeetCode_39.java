class Solution 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack( res , curr , 0 ,target,candidates,0);    
        return res;
    }
    public void backtrack( List<List<Integer>> res , List<Integer> curr , int sum ,int target,int[] candidates,int index)
    {
        if( sum == target )
        {
            if( !res.contains(curr) )
            {
                res.add(new ArrayList(curr));    
            }
            return;
        }
        for( int i = index ; i < candidates.length ; i++ )
        {
            if( sum + candidates[i] > target )
            {
                return;
            }
            curr.add( candidates[i] );
            sum = sum + candidates[i];
            backtrack( res , curr , sum , target , candidates ,i);  
            //adding index so it does'nt start from index 0 if current index is 1-n cauze that possiblity will have
            // already been covered when index was 0
            curr.remove( curr.size() - 1 );
            sum = sum - candidates[i];
        }
        
    }
}