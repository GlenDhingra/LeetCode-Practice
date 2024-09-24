class Solution {
    public int maxCoins(int[] piles) 
    {
        int low,med,high,sum;
        low = 0;
        high = piles.length-1;
        med = high - 1;
        sum = 0;
        Arrays.sort(piles);
        while( low < med )
        {
            sum += piles[med];
            low++;
            med = med-2;
            high = high-2;
        }
        return sum;
    }
}