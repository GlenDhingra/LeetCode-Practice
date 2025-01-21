class Solution {
    String result = "";
    int maxLength = 0;
    public String longestPalindrome(String s) {
        for( int i = 0 ; i < s.length() ; i++ ){
            getLength(s, i, i);
            getLength(s, i, i+1);
        }
        return result;
    }
    public void getLength( String s, int i, int j ){
        while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j) ){
            if( j - i >= maxLength ){
                result = s.substring(i, j+1);
                maxLength = j - i;
            }
            i--;
            j++;
        }
    }
}