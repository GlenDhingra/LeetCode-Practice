class Solution {
    public boolean checkOnesSegment(String s) 
    {
        if( s.length() == 1 )
        {
            return true;
        }
        int i = 1;
        while( i < s.length() && s.charAt(i) == '1' )
        {
            i++;
        }
        while( i < s.length() && s.charAt(i) == '0' )
        {
            i++;
        }
        return i == s.length();
    }
}