class Solution 
{
    public int numOfSubarrays(int[] arr, int k, int threshold) 
    {
        if( arr.length < k ) return 0;
        int count = 0 ,sum = 0 , i = 0 , j = 0;
        while( j < k )
        {
            sum += arr[j];
            j++;
        }
        if( sum / k >= threshold ) count++;
        while( j < arr.length )
        {
            sum -= arr[i];
            sum += arr[j];
            if( sum / k >= threshold ) count++;
            i++;
            j++;
        }
        return count;
    }
}
/*
Typical Sliding Window Problem
First we increment j till the max boundary required i.e. k  and add all the element between 0 to k in a variable sum
We check if avg of sum is greater than or equal to threshold and add count if yes
Then we remove elements at i and increment elements at j from sum and keep on checking the avg of sum
*/