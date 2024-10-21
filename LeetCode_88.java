class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[n+m];
        if( n == 0 || m == 0 ){
            if( m == 0 ){
                for( int i = 0 ; i < n ; i++ ){
                    nums1[i] = nums2[i];
                }
            }
        }
        else{
            int i = 0;
            int j = 0;
            int index = 0;
            while( i < m && j < n ){
                if( nums1[i] <= nums2[j] ){
                    res[index] = nums1[i];
                    i++;
                }
                else{
                    res[index] = nums2[j];
                    j++;
                }
                index++;
            }
            while( i < m ){
                res[index] = nums1[i];
                i++;
                index++;
            }
            while( j < n ){
                res[index] = nums2[j];
                j++;
                index++;
            }

            for( int a = 0 ; a < res.length ; a++ ){
                nums1[a] = res[a];
            }
        }
    }
}