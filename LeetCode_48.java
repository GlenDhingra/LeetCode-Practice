class Solution 
{
    public void rotate(int[][] matrix) 
    {
        int top = 0 ;
        int iright = 0;
        int bottom = matrix.length - 1;
        int ileft =  matrix.length - 1;
        int itr = 0;
        while( top < bottom )
        {
            flip( matrix , top , iright , bottom , ileft , itr ,  matrix.length );    
            top++;
            iright++;
            bottom--;
            ileft--;
            itr++;
        }
    }
    public void flip( int mat[][] , int top , int iright , int bottom , int ileft , int itr , int m )
    {
        int jtop = itr;
        
        int right = m - itr - 1;
        
        int jbottom = m - jtop - 1;
        
        int left = itr;
        
        while( jtop < m - itr - 1 )
        {

            int temp = mat[ top ][ jtop ];
            mat[ top ][ jtop ] = mat[ ileft ][ left ];
            mat[ ileft ][ left ] = mat[ bottom ][ jbottom ];
            mat[ bottom ][ jbottom ] = mat[ iright ][ right ] ;
            mat[ iright ][ right ]  = temp;
            
            
            jtop++;
            iright++;
            jbottom--;
            ileft--;
        }
    }
}