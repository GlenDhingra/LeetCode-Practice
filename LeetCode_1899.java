class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] arr = new int[]{0,0,0};
        for( int i = 0 ; i < triplets.length ; i++ ){
            
            if( triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2] ){
                arr[0] = Math.max(arr[0], triplets[i][0]);
                arr[1] = Math.max(arr[1], triplets[i][1]);
                arr[2] = Math.max(arr[2], triplets[i][2]);
            }
        }
        return Arrays.equals(arr, target);
    }
}