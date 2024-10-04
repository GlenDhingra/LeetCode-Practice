class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length()];
        int i = s.length()-1;
        while( i >= 0 ){
            String s1 = s.substring(i, s.length());
            for( int j = 0 ; j < wordDict.size() ; j++ ){
                if( s1.indexOf(wordDict.get(j)) == 0 ){
                    
                    if( i+wordDict.get(j).length() >= arr.length || arr[i+wordDict.get(j).length()] == true ){
                        arr[i] = true;
                    }
                }
            }
            i--;
        }
        return arr[0];
    }
}