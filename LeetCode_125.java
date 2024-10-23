class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while( i < j ){
            while( i < j && ( !Character.isDigit(s.charAt(i)) && !Character.isAlphabetic(s.charAt(i) ))  ){
                i++;
            }
            while( j > i && ( !Character.isDigit(s.charAt(j)) && !Character.isAlphabetic(s.charAt(j) ))  ){
                j--;
            }
            if( i < j && s.charAt(i) != s.charAt(j) ){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}