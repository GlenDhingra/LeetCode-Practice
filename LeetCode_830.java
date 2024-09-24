class Solution {
    public List<List<Integer>> largeGroupPositions(String s) 
    {
        List<List<Integer>> list = new ArrayList();
        int i = 0;
        int j = 0;
        
        while( i < s.length() && j < s.length() )
        {
            if( s.charAt(i) == s.charAt(j) )
            {
                j++;
            }
            else
            {
                if( j - i >= 3 )
                {
                    list.add(Arrays.asList(i,j-1));
                }
                i = j;
            }
        }
        System.out.println(i + " " + j);
        if( (j==s.length()) && j - i >= 3  )
        {
            list.add(Arrays.asList(i,j-1));    
        }
        return list;
        
    }
}