class Solution {
    public int diagonalSum(int[][] mat) 
    {
        int i=0,j=0;
        int m = mat.length;
        int n = mat[0].length;
        int sum = 0;

        //primary diagonal
        while( i < m && j < n )
        {
            //System.out.println(mat[i][j]);
            sum += mat[i][j];
            i++;
            j++;
        }
        
        //secondary diagonal
        i = 0;
        j = n - 1;
        
        while( i < m && j >= 0 )
        {
            //System.out.println(mat[i][j]);
            sum += mat[i][j];
            i++;
            j--;
        }
        
        if( mat.length % 2 != 0 )
        {
            sum -= mat[m/2][n/2];
        }
        
        return sum;
    }
}