class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) 
    {
        int res = 0;
        int i = 0;
        while( i < startTime.length )
        {
            if( startTime[i] <= queryTime && endTime[i] >= queryTime )
            {
                res++;
            }
            i++;
        }
        return res;
    }
}