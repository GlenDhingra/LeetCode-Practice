class Solution 
{
    public int kthSmallest(int[][] matrix, int k) 
    {
        int low = matrix[0][0];
        int high = matrix[ matrix.length - 1 ][ matrix[0].length - 1 ];
        while( low < high )
        {
            int mid = (high + low) / 2;
            int res = getSmallerElement(matrix,mid);
            if( res >= k )
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
    public int getSmallerElement( int[][] matrix , int val )
    {
        int count = 0;
        int i = 0;
        int j = matrix[0].length - 1;
        while( i < matrix.length && j >= 0 )
        {
            if( matrix[i][j] <= val )
            {
                count = count + j + 1;
                i++;
            }
            else
            {
                j--;
            }
        }
        return count;
    }
}