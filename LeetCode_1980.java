class Solution 
{
    String res="";
    public String findDifferentBinaryString(String[] nums) 
    {
        String curr = "";
        ArrayList<String> list = new ArrayList<>();
        for(String s: nums) list.add(s);
        backtrack(list,nums.length,curr);
        return res;
    }
    public void backtrack( ArrayList<String> list, int n,String curr)
    {
        if( curr.length() >= n  )
        {
            if(!list.contains(curr))
            {
                res = new String(curr);    
            }
            return;
        }
        if(res.length() > 0) return;
        backtrack(list,n,curr+"0");
        backtrack(list,n,curr+"1");
    }
}