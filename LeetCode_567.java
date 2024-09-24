class Solution 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        char[] c1 = s1.toCharArray();
        Arrays.sort( c1 );
        String p = new String(c1);
        int i = 0;
        int j = i + p.length() - 1;
        while( j < s2.length() )
        {
            String temp = s2.substring( i , j + 1 );
            char[] c2 = temp.toCharArray();
            Arrays.sort(c2);
            String s = new String(c2);
            if( s.equals(p) )
            {
                return true;
            }
            j++;
            i++;
        }
        return false;
    }
}
/*
Not a good approach
Have applied sliding window and sorted each time
*/