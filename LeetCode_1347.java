class Solution {
    public int minSteps(String s, String t) 
    {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int count = 0;
        for( int i = 0 ; i < s.length() ; i++ )
        {
            if( map1.containsKey(s.charAt(i)) )
            {
                map1.put( s.charAt(i) , map1.get(s.charAt(i)) + 1 );
            }
            else
            {
                map1.put( s.charAt(i) , 1 );
            }
        }
        for( int i = 0 ; i < t.length() ; i++ )
        {
            if( map1.containsKey(t.charAt(i)) )
            {
                if( map2.containsKey(t.charAt(i)) )
                {
                    map2.put( t.charAt(i) , map2.get(t.charAt(i)) + 1 );
                }
                else
                {
                    map2.put( t.charAt(i) , 1 );
                }    
            }
            else
            {
                count++;
            }
            
        }
        for( Map.Entry<Character,Integer> entry : map2.entrySet() )
        {
            if( entry.getValue() > map1.get(entry.getKey()) )
            {
                //System.out.println("map2 - " + entry.getValue());
                //System.out.println("map1 - " + map1.get(entry.getKey()));
                count +=  entry.getValue() - map1.get(entry.getKey());
            }
        }
        
        
        return count;
    }
}