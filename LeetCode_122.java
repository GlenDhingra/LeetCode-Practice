class Solution {
    public int maxProfit(int[] prices) {
        int currentMin = prices[0];
        int currentMax = prices[0];
        int result = 0;
        for( int i = 1 ; i < prices.length ; i++ ){
            if( prices[i] <= currentMax ){
                if( currentMin < currentMax ){
                    result += currentMax - currentMin;
                }
                currentMin = prices[i];
                currentMax = prices[i];
            }
            else{
                currentMax = Math.max(currentMax, prices[i]);
            }
        }
        if( currentMin < currentMax ){
            result += currentMax - currentMin;
        }
        return result;
    }
}
