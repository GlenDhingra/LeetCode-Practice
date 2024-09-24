class Solution 
{
    public int[] sumZero(int n) 
    {
        int[] res = new int[n];
        int i = 0;
        int j = res.length - 1;
        while( i < j )
        {
            res[i] = i - n;
            res[j] = n - i;
            i++;
            j--;
        }
        return res;
    }
}
/*
Two pointer approach
Place one pointer at start of res
Another pointer at end of res
To avoid duplicate values ,set the element at i to i - n (which will have a negative value as i will always be less than n)
set the abs of the element at i at j
thus their sum will always be zero

for odd number i == j will itself be 0 at initialization so that case will also be handled as zero would be a unique number as well
*/