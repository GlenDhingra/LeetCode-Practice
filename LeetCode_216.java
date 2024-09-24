class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        backtrack(res,curr,0,1,n,k);
        return res;
    }
    public void backtrack( List<List<Integer>> res,List<Integer> curr,int sum,int itr,int target,int length)
    {
        if( curr.size() == length )
        {
            if( sum == target ) res.add(new ArrayList<Integer>(curr));
            return;
        }
        if(sum > target) return;
        for( int i = itr ; i < 10 ; i++ )
        {
            sum += i;
            curr.add(i);
            backtrack(res,curr,sum,i+1,target,length);
            curr.remove(curr.size()-1);
            sum -= i;
        }
    }
}
/*
Backtracking Approach
Increment sum and curr List and check if the size of curr and sum are equal to k and n
*/