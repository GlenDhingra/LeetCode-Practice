class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for( int i = 1 ; i < matrix.length ; i++ ){
            for( int j = 0 ; j < matrix[i].length ; j++ ){
                int current = matrix[i][j];
                if( i-1 >= 0  && j-1 >= 0 ){
                    if( current != matrix[i-1][j-1] ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}