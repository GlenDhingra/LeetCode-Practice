class Solution {
    public void solve(char[][] board) {
        for( int i = 0 ; i < board.length ; i++ ){
            if( board[i][0] == 'O' ){
                helper(board, i, 0, 'O', 'T');
            }
            if( board[i][board[0].length-1] == 'O' ){
                helper(board, i, board[0].length-1, 'O', 'T');
            }
        }
        for( int j = 0 ; j < board[0].length ; j++ ){
            if( board[0][j] == 'O'  ){
                helper(board, 0, j, 'O', 'T');
            }
            if( board[board.length-1][j] == 'O' ){
                helper(board, board.length-1, j, 'O', 'T');
            }
        }

        for( int i = 0 ; i < board.length ; i++ ){
            for( int j = 0 ; j < board[i].length ; j++ ){
                if( board[i][j] == 'O' ){
                    helper(board, i, j, 'O', 'X');
                }
            }
        }

        for( int i = 0 ; i < board.length ; i++ ){
            if( board[i][0] == 'T' ){
                helper(board, i, 0, 'T', 'O');
            }
            if( board[i][board[0].length-1] == 'T' ){
                helper(board, i, board[0].length-1, 'T', 'O');
            }
        }
        for( int j = 0 ; j < board[0].length ; j++ ){
            if( board[0][j] == 'T'  ){
                helper(board, 0, j, 'T', 'O');
            }
            if( board[board.length-1][j] == 'T' ){
                helper(board, board.length-1, j, 'T', 'O');
            }
        }


    }
    public void helper( char[][] board, int i, int j, char source, char target ){
        if( i < 0 || i >= board.length || j < 0 || j >= board[i].length ){
            return;
        }
        if( board[i][j] == source ){
            board[i][j] = target;
            helper(board, i+1, j, source, target);
            helper(board, i, j+1, source, target);
            helper(board, i-1, j, source, target);
            helper(board, i, j-1, source, target);
        }
    }
}