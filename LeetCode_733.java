class Solution 
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        paint( sr,sc,image[sr][sc],newColor ,image );
        return image;
    }
    public void paint( int i , int j , int oldColor , int newColor , int[][] image) 
    {
        if( oldColor == newColor )
        {
            return;
        }
        if( ( i >= 0 && i < image.length ) && ( j >= 0 && j < image[i].length ) )
        {
            if( image[i][j] == oldColor )
            {
                image[i][j] = newColor;
                paint( i+1 ,  j , oldColor , newColor , image );
                paint( i-1 ,  j , oldColor , newColor , image );
                paint( i ,  j+1 , oldColor , newColor , image );
                paint( i ,  j-1 , oldColor , newColor , image );
            }
        }
    }
}
/*
Pass the new color and old color recrsively to nodes in 4 directions
Important: Make sure to check tha oldColor is NOT same as newColor
if same then skip that iteration cauze it will enter an infinite loop as both neighbours will change each other continuosly
*/