class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        int i = 0;
        int j = 0;
        while( i < nums.length )
        {
            if( nums[i] != 0 )
            {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        while( j < nums.length )
        {
            nums[j] = 0;
            j++;
        }
    }
}
/*
Two pointer approach
Make i traverse till the end
when i != 0, set the value of j to element at i
remaining elements from j to end will be zero
*/