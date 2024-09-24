class Solution 
{
    public int countGoodSubstrings(String s) 
    {  
        ArrayList<Character> list = new ArrayList<>();
        int count = 0;

        for( int i = 0 ; i < s.length() ; i++ )
        {
            if( list.size() == 3 )
            {
                list.remove(0);    
            }
            if( list.contains(s.charAt(i)) )
            {
                while( list.get(0) != s.charAt(i) )
                {
                    list.remove(0);
                }
                list.remove(0);
            }
            list.add(s.charAt(i));
            if( list.size() == 3 )
            {
                count++;
            }
        }
        return count;
    }
}
/*
Before adding a new element we check if arraylist already has an element or not
if element already present then we remove all elements until the same element in arraylist is removed
then we add the unique element to the arraylist

remove element only if arraylist size is 3
increase counter if arraylist size is 3[all elements entered in arraylist are unique]
*/