class Solution {
    public int longestBeautifulSubstring(String word) {
        int k = 0;
        int max = 0;
        int count = 1;
        for( int i = 1 ; i < word.length() ; i++ )
        {
            if( word.charAt(i) > word.charAt(i-1)  )
            {
                count++;
            }
            if( word.charAt(i) < word.charAt(i-1) )
            {
                if( count == 5 )
                {
                    max = Math.max( max , i - k );
                }
                k = i;    
                count = 1;
            }
        }
        if( count == 5 )
        {
            max = Math.max( max , word.length() - k );
        }
        return max;
    }
}
/*
Sliding Window Problem
Move i until you find a smaller character
if smaller character found then set max to max(max,k-i)
increment count when new element is encountered so that all vowels should be present in string
*/