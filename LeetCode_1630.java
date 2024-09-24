class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) 
    {
        List<Boolean> list = new ArrayList<>();
        for( int i = 0 ; i < l.length ; i++ )
        {
            int[] arr = Arrays.copyOfRange( nums , l[i] , r[i] + 1 );
            list.add(isSequence(arr)); 
        }
        return list;
    }
    public boolean isSequence( int[] arr )
    {
        Arrays.sort(arr);
        int seq = arr[1] - arr[0]; 
        for( int i = 1 ; i < arr.length ; i++ )
        {
            if( arr[i] - arr[i-1] != seq ) 
            {
                return false;
            }
        }
        return true;
    }
}