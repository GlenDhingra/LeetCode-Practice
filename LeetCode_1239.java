class Solution 
{
    int max = 0;
    public int maxLength(List<String> arr) 
    {
        HashSet<Character> set = new HashSet<>();
        backtrack( set , arr , 0 );
        return max;
    }
    public void backtrack( HashSet<Character> set,List<String> arr,int itr )
    {
        max = Math.max( max , set.size() );
        
        for( int i = itr ; i < arr.size() ; i++ )
        {
            int check = add( set , arr.get(i) );
            if( check == arr.get(i).length() )
            {
                backtrack( set , arr , i + 1 );    
            }
            remove( set , arr.get(i) ,check );
        }
    }
    
    /*
    Will return the index of the element already present in set
    If all characters are unique then it will return length of the string
    this will later be used as end point to remove characters from the set
    */
    public int add( HashSet<Character> set,String s )   
    {
        for( int i = 0 ; i < s.length() ; i++ )
        {
            if( set.contains( s.charAt(i) ) )
            {
                return i;
            }
            set.add(s.charAt(i));
        }
        return s.length();
    }
    public void remove( HashSet<Character> set,String s,int check )
    {
        for( int i = 0 ; i < check ; i++ )
            set.remove(s.charAt(i));
    }
}
/*
Backtracking Approach
Add all characters of a string in a Set [set has constant lookup]
If set already has the current character then return the index of the current character andONLY  remove character before that index[] they would  unique to  this string
If all characters of the string are unique then backtrack and update max
return max
*/