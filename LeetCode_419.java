class Solution 
{
    public int countBattleships(char[][] board) 
    {
        int count = 0;
        for( int i = 0 ; i < board.length ; i++ )
        {
            for( int j = 0 ; j < board[i].length ; j++ )
            {
                if( board[i][j] == 'X' )
                {
                    dfs(board,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs( char[][] board, int i, int j)
    {
        if( i >= 0 && i < board.length && j >= 0 && j < board[i].length )
        {
            if(board[i][j] == 'X')
            {
                board[i][j] = '.';
                dfs( board , i+1 , j );
                dfs( board , i-1 , j );
                dfs( board , i , j+1 );
                dfs( board , i , j-1 );
            }
        }
    }
}
/*
DFS approach
Count an X and mark all adjacent X's to .
Return the count
*/