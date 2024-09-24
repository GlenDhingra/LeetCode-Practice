class Solution {
    public String modifyString(String s) 
    {
        StringBuilder sb = new StringBuilder(s);
        Random rand = new Random();
        for( int i = 0 ; i < sb.length() ; i++ )
        {
            int left = i - 1;
            int right = i + 1;
            char cLeft = (left == -1)?'z':sb.charAt(left);
            char cRight = (right == sb.length())?'z':sb.charAt(right);
            if( sb.charAt(i) == '?' )
            {
                do
                {
                    sb.setCharAt(i,(char)('a' + rand.nextInt(26) ) );
                }while( sb.charAt(i) == cLeft || sb.charAt(i) == cRight );
            }
        }
        return sb.toString();   
    }
}