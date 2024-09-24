class Solution 
{
    public void rotate(int[] nums, int k) 
    {
        k %= nums.length;
        if( k == 0 ) return;
        int[] res = new int[nums.length];
        int i = nums.length - k;
        k = nums.length - k;
        int j = 0;
        while( i < nums.length )
        {
            res[j] = nums[i];
            i++;
            j++;
        }
        i=0;
        while( i < k )
        {
            res[j] = nums[i];
            i++;
            j++;
        }
        for( int a = 0 ; a < nums.length ; a++ )
        {
            nums[a] = res[a];
        }
    }
}