class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> curr = new ArrayList();
        backtrack(ans, curr, nums,0);
        return ans;
    }
    public void backtrack( List<List<Integer>> ans , List<Integer> curr , int[] nums ,int i )
    {
        ans.add(new ArrayList(curr));   
        //System.out.println(curr);       
        
        for( int i1 = i ; i1 < nums.length ; i1++ )
        {
            if( !curr.contains(nums[i1]) )
            {
                curr.add( nums[i1] );
                //System.out.println( curr );
                backtrack( ans , curr , nums , i1+1 );
                //System.out.println( curr );
                curr.remove( curr.size() - 1 );
            }   
        }
        
    }
}
/*
[]
[1]
[1]
[1, 2]
[1, 2]
[1, 2, 3]
[1, 2, 3]
[1, 2, 3]
[1, 2]
[1, 3]
[1, 3]
[1, 3]
[1]
[2]
[2]
[2, 3]
[2, 3]
[2, 3]
[2]
[3]
[3]
[3]
*/