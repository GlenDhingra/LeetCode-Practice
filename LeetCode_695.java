class Solution 
{
    public int maxAreaOfIsland(int[][] grid) 
    {
        int max = 0;
        for( int i = 0 ; i < grid.length ; i++ )
        {
            for( int j = 0 ; j < grid[i].length ; j++ )
            {
                if( grid[i][j] == 1 )
                {
                    max = Math.max(max,mark( grid, i , j ));
                }
            }
        }
        return max;
    }
    public int mark(int[][] grid, int i , int j )
    {
        int curr = 0;
        if( ( i >= 0 && i < grid.length ) && ( j >= 0 && j < grid[i].length ) )
        {
            if( grid[i][j] == 1 )
            {
                grid[i][j] = 0;
                curr += mark( grid , i+1 , j  );
                curr += mark( grid , i-1 , j  );
                curr += mark( grid , i , j+1  );
                curr += mark( grid , i , j-1  );
                return curr + 1;
            }
        }
        return 0;
    }
}
/*Follow these steps
if grid[i][j] is 1 then make it zero and more in 4 directions to find another 1 using recursion
if 1 is found then return all the adjacent number of 1's
*/