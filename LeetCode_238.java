class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int res[] = new int[nums.length];
        int product = 1;
        int zero = -1;
        int zeroCount = 0;
        
        for( int i = 0 ; i < nums.length ; i++ )
        {
            if( nums[i] == 0 )
            {
                zero = i;
                zeroCount++;
                if( zeroCount >= 2 )
                {
                    return res;
                }
            }
            else
            {
                product *= nums[i];
            }
        }
        if( zeroCount == 1 )
        {
            res[zero] = product;
            return res;
        }
        for( int i = 0 ; i < res.length ; i++ )
        {
            res[i] = product / nums[i];   
        }
        return res;
        
    }
}