class Solution {
    public String mostCommonWord(String paragraph, String[] banned) 
    {
        paragraph = paragraph.toLowerCase();
        HashMap<String,Integer> map = new HashMap<>();
        int i = 0 ;
        int j = 0;
        String largest = "";
        
        while( j < paragraph.length() )
        {
            if( Character.isAlphabetic(paragraph.charAt(j)) )
            {
                j++;
                if( j >= paragraph.length() )
                {   
                    
                    String s1 = paragraph.substring(i,j);
                    if( map.containsKey(s1) )
                    {
                        map.put( s1 , map.get(s1) + 1  );
                    }
                    else
                    {
                        map.put(s1 , 1);
                    }
                }
            }
            else
            {
                if( i == j  )
                {
                    i++;
                    j++;   
                }
                else
                {
                    String s = paragraph.substring(i,j);
                    if( map.containsKey(s) )
                    {
                        map.put( s , map.get(s) + 1  );
                    }
                    else
                    {
                        map.put(s , 1);
                    }
                    j++;
                    i=j;
                }
            }
        }
        for ( i = 0 ; i < banned.length ; i++ )
        {
            if( map.containsKey(banned[i]) )
            {
                map.remove(banned[i]);
            }
        }
        i=0;
        for( Map.Entry<String,Integer> entry : map.entrySet() )
        {
            if( entry.getValue() > i   )
            {
                i = entry.getValue();
                largest = entry.getKey();
            }
            System.out.println(entry);
        }
        return largest;  
    }
}