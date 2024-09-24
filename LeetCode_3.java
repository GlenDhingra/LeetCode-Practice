class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        
        while( j < s.length() )
        {
            if( !set.contains(s.charAt(j)) )
            {
                set.add( s.charAt(j) );
                j++;
            }
            else
            {
                max = Math.max( j - i , max );
                while( s.charAt(i) != s.charAt(j) )
                {
                    set.remove( s.charAt(i) );
                    i++;
                }
                set.remove( s.charAt(i) );
                i++;
            }
        }
        max = Math.max( j - i , max );
        return max;
    }
}
/*
Sliding Window Problem
Add elements of j to a set
if an element already present in the set is encountered then
remove all elements from the set at i till the duplicate of element at j is not found
*/