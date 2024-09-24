class Solution 
{
    int max = 0;
    public int getMaximumGold(int[][] grid) 
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];  
        for( int i = 0 ; i < grid.length ; i++ )
        {
            for( int j = 0 ; j < grid[i].length ; j++ )
            {
                backtrack(grid,visited,0,i,j);        
            }
        }
        return max;
    }
    public void backtrack( int[][] grid,boolean[][] visited, int sum,int i,int j )
    {
        max = Math.max(sum,max);
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] != 0 && visited[i][j] == false)
        {
            visited[i][j] = true;
            sum += grid[i][j];
            backtrack(grid,visited,sum,i+1,j);
            backtrack(grid,visited,sum,i-1,j);
            backtrack(grid,visited,sum,i,j+1);
            backtrack(grid,visited,sum,i,j-1);
            sum -= grid[i][j];
            visited[i][j] = false;
        }
    }
}
/*
Baktracking
Make use of boolean array to mark visited element
*/