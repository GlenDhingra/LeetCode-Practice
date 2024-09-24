class Solution 
{
    public List<String> letterCombinations(String digits) 
    {
        List<String> res = new ArrayList<>();
        if( digits == null || digits.length() == 0 )
        {
            return res;
        }
        String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        backtrack( res , digits , "" , 0 , map );
        return res;
    }
    public void backtrack( List<String> res , String digits , String curr , int index , String[] map )
    {
        if( curr.length() == digits.length() )
        {
            res.add(curr);
            return;
        }
        String level = map[ digits.charAt(index) - '0' ];
        for( int i = 0 ; i < level.length() ; i++ )
        {
            backtrack( res , digits , curr + level.charAt(i) , index + 1 , map );
        }
    }
}