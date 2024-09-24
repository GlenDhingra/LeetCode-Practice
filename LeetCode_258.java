class Solution {
    public int addDigits(int num) 
    {
        while( num >= 10 )
        {
            int n = num % 10;
            num /= 10;
            num += n;
        }
        return num;
    }
}