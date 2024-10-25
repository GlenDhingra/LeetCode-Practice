class TicTacToe {

    int rowA[];
    int colA[];

    int rowB[];
    int colB[];

    int[][] matrix;
    int size;
    public TicTacToe(int n) {
        size = n;
        matrix = new int[n][n];

        rowA = new int[n];
        colA = new int[n];

        rowB = new int[n];
        colB = new int[n];
    }
    
    public int move(int row, int col, int player) {
        if( player == 1 ){
            matrix[row][col] = 2;
            rowA[row]++;
            colA[col]++;
            if( rowA[row] == size || colA[col] == size || checkLeftDiagonal(matrix, 0, 0, 2) == size || checkRightDiagonal(matrix, 0, size-1, 2) == size ){
                return 1;
            }
        }
        else if( player == 2 ){
            matrix[row][col] = 4;
            rowB[row]++;
            colB[col]++;
            if( rowB[row] == size || colB[col] == size || checkLeftDiagonal(matrix, 0, 0, 4) == size || checkRightDiagonal(matrix, 0, size-1, 4) == size ){
                return 2;
            }
        }
        return 0;
    }

    public int checkLeftDiagonal( int[][] matrix, int row, int col, int value ){
        int i = row;
        int j = col;
        int count = 0;
        
        while( i < matrix.length && j < matrix[i].length ){
            if( matrix[i][j] == value ){
                i++;
                j++;
                count++;
            }
            else{
                return 0;
            }
        }
        
        return count;
    }
    public int checkRightDiagonal( int[][] matrix, int row, int col, int value ){
        int i = row;
        int j = col;
        int count = 0;

        while( i < matrix.length && j >= 0 ){
            if( matrix[i][j] == value ){
                i++;
                j--;
                count++;
            }
            else{
                return 0;
            }
        }
        
        return count;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */