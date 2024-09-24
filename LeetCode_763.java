class Solution {
    public List<Integer> partitionLabels(String s) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = s.lastIndexOf(s.charAt(i));
        while( s.length() > 0 )
        {
            while( i <= j )
            {
                j = Math.max(j,s.lastIndexOf(s.charAt(i)));
                i++;
            }
            list.add( i );
            s = s.substring(i,s.length());
            i = 0;
            if( i < s.length() )
            {
                j = s.lastIndexOf(s.charAt(i));
            }
        }
        return list;
    }
}