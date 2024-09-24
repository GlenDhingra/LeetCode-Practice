class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) 
    {
        List<String> list = new ArrayList<>();
        for( int i = 0 ; i < words.length ; i++ )
        {
            if( match(words[i] , pattern) )
            {
                list.add(words[i]);
            }
        }
        return list;
    }
    public boolean match( String word, String pattern )
    {
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        for( int i = 0 ; i < word.length() ; i++ )
        {
            char a = word.charAt(i);
            char b = pattern.charAt(i);

            if( !map1.containsKey(a) )
            {
                map1.put(a,b);
            }
            if( !map2.containsKey(b) )
            {
                map2.put(b,a);
            }
            if( map1.get(a) != b || map2.get(b) != a )
            {
                return false;
            }
        }
        return true;
    }
}