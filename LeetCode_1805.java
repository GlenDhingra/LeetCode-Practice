```
class Solution {
    public int numDifferentIntegers(String word) 
    {
        HashSet<String> set = new HashSet();
        int i = 0;
        int j = 0;
        while( j < word.length() )
        {
            if( word.charAt(j) >= '0' && word.charAt(j) <= '9' )
            {
                j++;
                if( j >= word.length()  )  // To add numbers at the end of the string to HashSet
                {   
                    StringBuilder s = new StringBuilder(word.substring(i,j));
					while( s.length() > 0 && s.charAt(0) == '0' ) // To remove Leading 0's
                    {
                        s.deleteCharAt(0);
                    }
                    set.add(s.toString());    
                }
            }
            else
            {
                if( i != j )
                {
						StringBuilder s1 = new StringBuilder(word.substring(i,j));//To add number to the HashSet
                    while( s1.length() > 0 && s1.charAt(0) == '0' )
                    {
                        s1.deleteCharAt(0);
                    }
                    set.add(s1.toString());
                    i=j;
                }
                else
                {
                    i++;
                    j++;
                }
            }
        }
        return set.size();
    }
}