class Solution {
    public String longestWord(String[] words) 
    {      
        HashSet<String> list = new HashSet<>();
        
        Arrays.sort(words);
        String result= "";
        for( int i = 0 ; i < words.length ; i++ )
        {
            if( words[i].length() == 1 || list.contains(words[i].substring(0,words[i].length()-1)) )
            {
                list.add(words[i]);
                if( words[i].length() > result.length() )
                {
                    result = words[i];
                }
            }
        }
        return result;
    }
}