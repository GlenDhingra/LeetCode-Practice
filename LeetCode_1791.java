class Solution 
{
    public int findCenter(int[][] edges) 
    {
        int[] arr = new int[edges.length+2];
        
        for( int i = 0 ; i < 2 ; i++ )
        {
            for( int j = 0 ; j < edges[i].length ; j++ )
            {
                arr[edges[i][j]]++;
            }
        }
        for( int i = 0 ; i < arr.length ; i++ )
        {
            if( arr[i] > 1 )
            {
                return i;
            }
        }
        return 0;
    }
}