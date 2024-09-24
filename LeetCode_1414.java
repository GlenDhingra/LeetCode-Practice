class Solution 
{
    public int findMinFibonacciNumbers(int k) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        fib(list,k);
        int count = 0;
        int i = list.size() - 1;
        int curr = 0;
        while( curr < k && i >= 0)
        {
            if(curr + list.get(i) <= k)
            {
                curr += list.get(i);
                count++;
            }
            i--;
        }
        return count;
        
    }
    public void fib( ArrayList<Integer> list,int k)
    {
        int f1 = 0;
        int f2 = 1;
        list.add(f1);
        list.add(f2);
        int f3 = f1 + f2;
        while( f3 <= k )
        {
            list.add(f3);
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
    }
}