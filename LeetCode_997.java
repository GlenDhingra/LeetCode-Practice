class Solution {
    public int findJudge(int N, int[][] trust) 
    {
        int[] count = new int[N+1];
        for( int i = 0 ; i < trust.length ; i++ )
        {
            count[trust[i][0]]--;
            count[trust[i][1]]++;
            System.out.println(count[trust[i][1]]);
        }
        for( int i = 1 ; i <= N ; i++ )
        {
            if( count[i] == N-1 )
            {
                return i;    
            }
        }
        return -1;
    }
}