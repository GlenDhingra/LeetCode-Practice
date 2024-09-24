class Solution {
    public int matrixScore(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        
        for( int i = 0 ; i < m ; i++ )
        {
            if( grid[i][0] == 0 )
            {
                flipRow( grid , i );
            }
        }
        
        for( int j = 1 ; j < n ; j++ )
        {
            if( moreZero( grid , j ))
            {
                  flipCol( grid , j );
            }
        }
        int sum = 0;
        for( int i = 0 ; i < m ; i++ )
        {
            System.out.println(Arrays.toString(grid[i]));
            sum += getInt(grid[i]);
        }
        return sum;
    }
    public boolean moreZero( int[][] grid , int j )
    {
        int count = 0;
        for( int i = 0 ; i < grid.length ; i++  )
        {
            if( grid[i][j] == 0 )
            {
                count++;
            }
        }
        return count > grid.length / 2;
    }
    
    public int[][] flipRow( int[][] grid , int i )
    {
        for( int j = 0 ; j < grid[i].length ; j++ )
        {
            if( grid[i][j] == 1 )
            {
                grid[i][j] = 0;
            }
            else
            {
                grid[i][j] = 1;
            }
        }
        return grid;
    }
    public int[][] flipCol( int[][] grid , int j )
    {
        for( int i = 0 ; i < grid.length ; i++ )
        {
            if( grid[i][j] == 1 )
            {
                grid[i][j] = 0;
            }
            else
            {
                grid[i][j] = 1;
            }
        }
        return grid;
    }
    
    
    public int getInt( int[] arr )
    {
        double sum = 0;
        for( int i = arr.length - 1 ; i >= 0 ; i-- )
        {
            if( arr[i] == 1 )
            {
                sum = sum + Math.pow(2, arr.length - i - 1 );
            }
        }
        return (int)sum;
    }
}