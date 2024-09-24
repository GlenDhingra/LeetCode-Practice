class Solution 
{
    public void sortColors(int[] nums) 
    {
        mergeSort(nums,0,nums.length-1);
    }
    public void mergeSort( int[] nums,int start,int end )
    {
        if( start < end )
        {
            int mid = (start + end) / 2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    public void merge( int[] nums, int start,int mid, int end )
    {   
        int temp[] = new int[ nums.length ];
        int i = start;
        int j = mid+1;
        int k = start;
        while( i <= mid && j <= end)
        {
            if( nums[i] <= nums[j] )
            {
                temp[k] = nums[i];
                i++;
                k++;
            }
            else
            {
                temp[k] = nums[j];
                j++;
                k++;
            }
        }
        while( i <= mid )
        {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while( j <= end )
        {
            temp[k] = nums[j];
            j++;
            k++;   
        }
        for( int a = start; a <= end ; a++ )
        {
            nums[a] = temp[a];
        }

    }
    
}