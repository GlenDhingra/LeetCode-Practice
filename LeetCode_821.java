class Solution 
{
    public int[] shortestToChar(String s, char c) 
    {
        int[] res = new int[s.length()];    
        int prev = s.indexOf(c);
        int i = 0;
        while( i <= prev )
        {
            res[i] = prev - i;
            i++;
        }
        int next = prev + 1;
        while( next < s.length() )
        {
            while( next < s.length() && s.charAt(next) != c )
            {
                next++;
            }
            if(next == s.length()) 
                next = Integer.MAX_VALUE-1;
            while( i < s.length() && i < next )
            {
                res[i] = Math.min( Math.abs(prev - i) , Math.abs(next - i) );
                i++;
                
            }
            prev = next;
            next = prev + 1;
        }
        return res;
    }
}