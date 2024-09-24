class Solution 
{
    public boolean isNStraightHand(int[] hand, int groupSize) 
    {
        if( hand.length % groupSize != 0 ) return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();    
        for( int i : hand)
        {
            if(map.containsKey(i)) map.replace(i,map.get(i)+1);
            else map.put(i,1);
        }
        while( map.size() > 0 )
        {
            
            int req = map.firstKey();
            for(int i = 0 ; i < groupSize ; i++ )
            {
                if(!map.containsKey(req)) return false;
                
                if(map.get(req) == 1) map.remove(req);
                else map.replace(req,map.get(req)-1);
                
                req++;
            }
        }
        return true;
    }
}