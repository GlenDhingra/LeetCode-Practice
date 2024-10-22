class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        int iCol = 0;
        int iRow = 0;
        int row = mat.length;
        int col = mat[0].length;
        boolean goUp = true;
        boolean goDown = false;
        int index = 0;
        while( index < res.length ){
            if( goUp ){
                while( iCol < col && iRow >= 0 ){
                    res[index] = mat[iRow][iCol];
                    iRow--;
                    iCol++;
                    index++;
                }
                iRow++;
                iCol--;
                if( iCol + 1 < col ){
                    iCol++;
                }
                else{
                    iRow++;
                }
                goUp = false;
                goDown = true;
            } else{
                while( iCol >= 0 && iRow < row ){
                    res[index] = mat[iRow][iCol];
                    iRow++;
                    iCol--;
                    index++;
                }
                iRow--;
                iCol++;
                if( iRow + 1 < row ){
                    iRow++;
                }
                else{
                    iCol++;
                }
                goDown = false;
                goUp = true;
            }
        }   
        return res;
    }
}