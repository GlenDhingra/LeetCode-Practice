class Solution 
{
    public int findTheWinner(int n, int k) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        for( int i = 0 ; i < n ; i++ )
        {
            list.add(i + 1);
        }
        
        int count = 0;
        while( list.size() != 1 )
        {
            count = ( count + k - 1 ) % list.size();
            list.remove(count);
        }
        return list.get(0);
    }
}