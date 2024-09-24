class Solution {
    public int minSetSize(int[] arr) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for( int i = 0 ; i < arr.length ; i++ )
        {
            if( map.containsKey( arr[i] ))
            {
                map.put( arr[i] , map.get(arr[i]) + 1 );
            }
            else
            {
                map.put( arr[i] , 1 );
            }
        }
        if( map.size() == 1 )
        {
            return 1;
        }
        LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
        
        map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
            .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        
        int count = 0;
        int count1 = 0;
        int len = arr.length / 2;
        for( Map.Entry<Integer,Integer> entry : reverseSortedMap.entrySet() )
        {
           if( count1 < len )
           {
               count1 += entry.getValue();
               count += 1;
           }
        }
        return count;
    }
}