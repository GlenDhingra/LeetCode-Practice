class Solution {
    public int maxProfit(int[] prices) 
    {
        int i = 0;
        int j = i + 1;
        int count = 0;
        
        while( j < prices.length )
        {
            if( prices[j] < prices[i] )
            {
                i++;
                j++;
            }
            else if( prices[j] > prices[i] )
            {
                while( j < prices.length - 1 && prices[j+1] > prices[j]  )
                {
                    j++;
                }
                count += prices[j] - prices[i];
                i = j + 1;
                j = i + 1;
            }
            else
            {
                j++;
                i++;
            }
        }
        return count;
    }
}