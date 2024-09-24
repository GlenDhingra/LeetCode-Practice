class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for( int i = 0 ; i < nums.length ; i++ )
        {
            if( map.containsKey(nums[i]) ) 
            {
                map.put( nums[i] , map.get(nums[i]) + 1 );
            }
            else
            {
                map.put( nums[i] , 1 );
            }
            
        }
        LinkedHashMap<Integer,Integer> reverseSortedMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted( Map.Entry.comparingByValue( Comparator.reverseOrder() ) )
            .forEachOrdered( x -> reverseSortedMap.put( x.getKey() , x.getValue() ) );
        int i = 0;
        int[] res = new int[k];
        for( Map.Entry<Integer,Integer> entry : reverseSortedMap.entrySet() )
        {
            if( i < k )
            {
                res[i] = entry.getKey();
                i++;
            }
            else
            {
                break;
            }
        }
        return res;
        
    }
}
