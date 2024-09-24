class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> curr = new ArrayList();
        backtrack( ans , curr , nums ); 
        return ans;
    }
    public void backtrack(List<List<Integer>> ans , List<Integer> curr , int[] nums )
    {
        if( curr.size() != nums.length )
        {
            for( int i = 0 ; i < nums.length ; i++ )
            {
                if( !curr.contains(nums[i]) )
                {
                    curr.add(nums[i]);
                    
                    backtrack( ans , curr, nums );
                    
                    curr.remove(curr.size()-1);
                }
            }
        }
        else
        {
            ans.add(new ArrayList(curr));
        }
    }
}
/*
[1]
[1, 2]
[1, 2, 3]
[1, 2]
[1]
[1, 3]
[1, 3, 2]
[1, 3]
[1]
[]
[2]
[2, 1]
[2, 1, 3]
[2, 1]
[2]
[2, 3]
[2, 3, 1]
[2, 3]
[2]
[]
[3]
[3, 1]
[3, 1, 2]
[3, 1]
[3]
[3, 2]
[3, 2, 1]
[3, 2]
[3]
[]
*/