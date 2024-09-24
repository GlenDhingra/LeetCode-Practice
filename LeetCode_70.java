class Solution {
    public int climbStairs(int n) 
    {
        int fib1 = 1;
        int fib2 = 1;
        if( n == 1  )
        {
            return 1;
        }
        int fib3 = fib2+fib1;
        for( int i = 2 ; i < n ; i++ )
        {
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib2 + fib1;
        }
        return fib3;
    }
}