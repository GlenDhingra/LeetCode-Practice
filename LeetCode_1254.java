class Solution 
{
    public int closedIsland(int[][] grid) 
    {
        int count = 0;
        for( int i = 0 ;  i < grid.length ; i++ )       //Marking 0's on vertical edge
        {
            int j = 0;
            if( grid[i][j] == 0 )
            {
                traverse( i , j ,0, 5, grid );
            }
            j = grid[i].length-1;
            if( grid[i][j] == 0 )
            {
                traverse( i , j ,0, 5, grid );
            }
        }
        for( int j = 0 ; j < grid[0].length ; j++ )     //Marking 0's on horizontal edge
        {
            int i = 0;
            if( grid[i][j] == 0 )
            {
                traverse( i , j ,0, 5, grid );
            }
            i = grid.length - 1;
            if( grid[i][j] == 0 )
            {
                traverse( i , j ,0, 5, grid );
            }
        }
        for( int i = 0 ; i < grid.length ; i++ )           //Marking 0's with water on 4 sides
        {
            for( int j = 0 ; j < grid[i].length ; j++ )
            {
                if( grid[i][j] == 0 )
                {
                    traverse( i , j ,0, 2 , grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void traverse( int i, int j,int oldDigit,int newDigit,int[][] grid )
    {
        if( ( i >= 0 && i < grid.length ) && ( j >= 0 && j < grid[i].length ) )
        {
            if( grid[i][j] == oldDigit )
            {
                grid[i][j] = newDigit;
                traverse(i+1,j,oldDigit,newDigit,grid);
                traverse(i-1,j,oldDigit,newDigit,grid);
                traverse(i,j+1,oldDigit,newDigit,grid);
                traverse(i,j-1,oldDigit,newDigit,grid);
            }
        }
    }
}
/*
First we mark all the groups of 0's on the edges as they don't have water on aall 4 sides
Remaining 0's will always have water on all 4 sides so return the count of their groups
*/