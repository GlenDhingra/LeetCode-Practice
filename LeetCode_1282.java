class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) 
    {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList();
        for( int i = 0 ; i < groupSizes.length ; i++ )
        {
            if( map.containsKey( groupSizes[i] ) )
            {
                map.get( groupSizes[i] ).add(i);
                if( map.get(groupSizes[i]).size() == groupSizes[i] )
                {
                    res.add( map.get(groupSizes[i]) );
                    map.remove( groupSizes[i] );
                }
            }
            else
            {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i],list);
                if( map.get(groupSizes[i]).size() == groupSizes[i] )
                {
                    res.add( map.get(groupSizes[i]) );
                    map.remove( groupSizes[i] );
                }
            }
        }
        return res;
    }
}