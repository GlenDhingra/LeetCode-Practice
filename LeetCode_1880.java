class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) 
    {
        int a = sumOfLetters(firstWord);
        int b = sumOfLetters(secondWord);
        int c = sumOfLetters(targetWord);
        System.out.println(a + " " + b + " " +c );
        return a + b == c;
    }
    
    public int sumOfLetters( String s )
    {
        int sum = 0;
        for( int i = 0 ; i < s.length() ; i++ )
        {
            sum *= 10;
            sum += s.charAt(i) - 'a';
        }
        return sum;
    }
    
}