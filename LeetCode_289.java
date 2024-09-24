class Solution {
    public void gameOfLife(int[][] board) 
    {
        int[][] res = new int[board.length][board[0].length];
        for( int i = 0 ; i < board.length ; i++ )
        {
            for( int j = 0 ; j < board[i].length ; j++ )
            {
                isAlive( board , i , j ,res );
            }
        }
        for( int i = 0 ; i < board.length ; i++ )
        {
            for( int j = 0 ; j < board[i].length ; j++ )
            {
                board[i][j] = res[i][j];
            }
        }
        
    }
    public void isAlive( int[][] board , int i , int j , int[][] res)
    {
        int[] arr = new int[]{0,0};
       //top left
        if( i - 1 >= 0 && j - 1 >= 0 )
        {
            count( board[i-1][j-1] , arr );
        }
        //left
        if( i >= 0 && j - 1 >= 0 )
        { 
            count( board[i][j-1] , arr );
        }
        //bottom left
        if( i + 1 < board.length && j - 1 >= 0 )
        {
            count( board[i+1][j-1] , arr );
        }
        //top
        if( i - 1 >= 0 && j >= 0 )
        {
            count( board[i-1][j] , arr );
        }
        //bottom
        if( i + 1 < board.length && j >= 0 )
        {
            count( board[i+1][j] , arr );
        }
        //top right
        if( i - 1 >= 0 && j + 1 < board[i].length )
        {
            count( board[i-1][j+1] , arr );
        }
        //right
        if( i >= 0 && j + 1 < board[i].length )
        {
            count( board[i][j+1] , arr );
        }
        if( i + 1 < board.length && j + 1 < board[i].length )
        {
            count( board[i+1][j+1] , arr );
        }
        if( board[i][j] == 0 && arr[1] == 3 )
        {   
            res[i][j] = 1;
        }
        if( board[i][j] == 1 )
        {
            if( arr[1] >= 2 && arr[1] <= 3 )
            {
                res[i][j] = 1;
            }
        }  
        
    }
    public void count(int a, int[] arr)
    {
        if( a == 0 )
            arr[0] += 1;
        else
            arr[1] += 1;
    }
}