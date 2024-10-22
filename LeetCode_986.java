class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        ArrayList<int[]> list = new ArrayList<>();
        while( i < firstList.length && j < secondList.length ){
            int[] first = firstList[i];
            int[] second = secondList[j];

            if( (first[1] >= second[0] && first[1] <= second[1] ) || ( second[1] >= first[0] && second[1] <= first[1] ) ){

                int[] arr = new int[]{ Math.max(first[0], second[0]), Math.min(first[1], second[1]) };
                list.add(arr);
            }
            if( first[1] <= second[1] ){
                i++;
            } else{
                j++;
            }
            
        }
        int[][] res = new int[list.size()][2];
        for( int k = 0 ; k < res.length ; k++ ){
            res[k] = list.get(k);
        }
        return res;
    }
}
