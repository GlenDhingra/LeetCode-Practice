class Solution {
    public int minFlips(String target) 
    {
        char[] arr = target.toCharArray();
        int count = 0;
        char prev = '0';

        for( int j = 0 ; j < arr.length ; j++ )
        {
            if( arr[j] != prev )
            {
                count++;
                prev = arr[j];
            }
        }
        return count;
        
    }
}