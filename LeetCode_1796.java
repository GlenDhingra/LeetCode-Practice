class Solution {
    public int secondHighest(String s) 
    {
        ArrayList<Integer> array = new ArrayList();
        
        for( int i = 0 ; i < s.length() ; i++ )
        {
            if( Character.isDigit(s.charAt(i)) && !array.contains(Character.getNumericValue(s.charAt(i)))  )
            {
                array.add(Character.getNumericValue(s.charAt(i)));
            }
        }
        
        Collections.sort(array, Collections.reverseOrder());
        if( array.size() >= 2 )
        {
            return array.get(1);
        }
        return -1;
    }
}