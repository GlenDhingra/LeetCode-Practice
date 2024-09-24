class Solution 
{
    public int longestOnes(int[] nums, int k) 
    {
        int max = 0,count = 0,i = 0,pointer = i;
        while( i < nums.length  )
        {
            if( nums[i] == 0 )
            {
                count++;
                if( count > k )
                {
                    while( pointer < i && nums[pointer] == 1 )
                    {
                       pointer++;
                    }
                    pointer++;
                    count--;
               }
            }
            i++;
            max = Math.max( (i - pointer)  , max );
        }
        return max;
    }
}
