class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0;
        int j = 0;

        while( j < s.length() ){
            if( !set.contains(s.charAt(j)) ){
                set.add( s.charAt(j) );
                j++;
                maxLength = Math.max( j - i, maxLength );
            }
            else{
                set.remove( s.charAt(i) );
                i++;
            }
        }
        return maxLength;
    }
}
/*
*/