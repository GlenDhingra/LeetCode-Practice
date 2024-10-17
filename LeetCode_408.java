class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while( i < word.length() && j < abbr.length() ){
            if( Character.isLetter(abbr.charAt(j)) && word.charAt(i) != abbr.charAt(j) ){
                return false;
            }
            else if( Character.isDigit(abbr.charAt(j)) ){
                int num = 0;
                if( abbr.charAt(j) == '0'){
                    return false;
                }
                while( j < abbr.length() && Character.isDigit(abbr.charAt(j)) ){
                    num = num + ( abbr.charAt(j) - '0' );
                    num *= 10;
                    j++;
                }
                num /= 10;
                i += num;
            }
            else{
                i++;
                j++;
            }
            
        }  
        return i == word.length() && j == abbr.length();
    }
}