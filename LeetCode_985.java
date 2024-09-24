class Solution 
{
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) 
    {
        int[] res = new int[nums.length];
        int j = 0;
        int sum = 0;
        for( int i = 0 ; i < nums.length ; i++ )
        {
            if( nums[i] % 2 == 0 ) 
                sum += nums[i];
        }
        
        for( int i = 0 ; i < queries.length ; i++ )
        {
            int index = queries[i][1];
            if( nums[index] % 2 == 0 ) 
                sum -= nums[index];
            nums[index] = nums[index] + queries[i][0];
            if( nums[index] % 2 == 0 ) 
                sum += nums[index];
            res[j] = sum;
            j++;
        }
        return res;
    }
}