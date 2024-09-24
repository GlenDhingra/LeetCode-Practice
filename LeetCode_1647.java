class Solution 
{
    public int minDeletions(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for( int i = 0 ; i < s.length() ; i++ )
        {
            map.put( s.charAt(i) , map.getOrDefault( s.charAt(i) , 0 ) + 1 );
        }
        
        List<Integer> list = new ArrayList(map.values());
        HashSet<Integer> set = new HashSet<>();
        
        //Method 1
        Collections.sort(list,Collections.reverseOrder());
        for( int i = 1 ; i < list.size() ; i++ )
        {
            while( list.get(i) > 0 && list.get(i) >= list.get(i-1) )
            {
                int rem = list.remove(i);
                rem--;
                list.add(i,rem);
                count++;
            }
        }
        //Method 2
        /*
        for( int i = 0 ; i < list.size() ; i++ )
        {
            while( set.contains(list.get(i)) && list.get(i) > 0  )
            {
                int rem = list.remove(i);
                rem--;
                list.add(i,rem);
                count++;
            }
            set.add(list.get(i));
        }
        */
        return count;
    }
}
/*
Count the frequency of the character and store them in a hashMap

Method 1
Access the values of hashmap and sort them in descending order
if the value at i is equal to value at i - 1 then reduce value at element i
ignore 0 case

Method 2
Access values in hashmap and add them to a set
if set contains the value then decrement value and check again
*/