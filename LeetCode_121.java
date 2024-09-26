class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for( int i = 0 ; i < prices.length ; i++ ){
            if( prices[i] > max ){
                max = prices[i];
                maxProfit = Math.max(max - min, maxProfit);
            }    
            if( prices[i] < min ){
                max = Integer.MIN_VALUE;
                min = prices[i];
            }

        }
        return maxProfit;
    }
}