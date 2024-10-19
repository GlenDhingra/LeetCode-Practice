class Solution {
    double p[];
    Random random;
    int w[];

    public Solution(int[] w) {
        this.w = w;
        this.p = new double[w.length];
        random = new Random();
        int sum = 0;
        for( int i = 0 ; i < w.length ; i++ ){
            sum += w[i];
        }
        p[0] = (double)w[0] / sum;
        for( int i = 1 ; i < w.length ; i++ ){
            p[i] = p[i-1] + ((double)w[i]/sum);
        }
    }
    
    public int pickIndex() {
        double target = random.nextDouble();
        int left = 0;
        int right = p.length - 1;
        while( left < right ){
            int mid = (left+right) / 2;
            if( p[mid] < target ){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */