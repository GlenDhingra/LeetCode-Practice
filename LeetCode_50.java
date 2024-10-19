class Solution {
    public double myPow(double x, int n) {
        if( n < 0 ){
            x = 1 / x;
            n *= -1;
        }
        double result = dfs(x, x, n);
        return result;
    }
    public double dfs( double og, double x, int n ){
        double result;
        if( n == 0 ){
            return 1;
        }
        if( n == 1 ){
            return og;
        }
        int n1 = n / 2;
        double temp = dfs(og,x,n1);
        if( n % 2 == 0 ){
            result = temp * temp;
        }
        else{
            result = temp * temp * og;
        }
        return result;
    }
}
