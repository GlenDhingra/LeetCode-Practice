class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int prevFresh = 0;
        int time = 0;
        for( int i = 0 ; i < grid.length ; i++ ){
            for( int j = 0 ; j < grid[i].length ; j++ ){
                if( grid[i][j] == 1 ){
                    prevFresh++;
                }
                else if( grid[i][j] == 2 ){
                    queue.offer( new int[]{i, j} );
                }
            }
        }
        if( prevFresh == 0 ){
            return 0;
        }
        int currFresh = prevFresh;
        while( !queue.isEmpty() ){
            int size = queue.size();
            for( int i = 0 ; i < size ; i++ ){
                int[] currElement = queue.poll();
                int row = currElement[0];
                int col = currElement[1];
                if( checkFresh(row+1, col, grid) ){
                    queue.offer( new int[]{row+1, col} );
                    grid[row+1][col] = 2;
                    currFresh--;
                }
                if( checkFresh(row-1, col, grid) ){
                    queue.offer( new int[]{row-1, col} );
                    grid[row-1][col] = 2;
                    currFresh--;
                }
                if( checkFresh(row, col+1, grid) ){
                    queue.offer( new int[]{row, col+1} );
                    grid[row][col+1] = 2;
                    currFresh--;
                }
                if( checkFresh(row, col-1, grid) ){
                    queue.offer( new int[]{row, col-1} );
                    grid[row][col-1] = 2;
                    currFresh--;
                }
            }
            if(currFresh == prevFresh){
                return -1;
            }
            time++;
        }
        if( currFresh > 0 ){
            return -1;
        }
        return time-1;
    }
    public boolean checkFresh( int i, int j, int[][] grid ){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[i].length ){
            return false;
        }
        if( grid[i][j] == 1 ){
            return true;
        }
        return false;
    }
}