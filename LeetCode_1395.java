class Solution {
    public int numTeams(int[] rating) 
    {
        int count = 0;
        for( int i = 1 ; i < rating.length - 1 ; i++ )
        {
            int leftLess = 0;
            int leftGreat = 0;
            
            int rightLess = 0;
            int rightGreat = 0;
            
            for( int j = i - 1 ; j >= 0 ; j-- )
            {
                if( rating[i] < rating[j] )
                {
                    leftGreat++;
                }
                else
                {
                    leftLess++;
                }
            }
            
            for( int j = i + 1 ; j < rating.length ; j++ )
            {
                if( rating[i] < rating[j] )
                {
                    rightGreat++;
                }
                else
                {
                    rightLess++;
                }
            }
            
            count += (leftLess * rightGreat ) + ( leftGreat * rightLess );
        }
        return count;
    }
}