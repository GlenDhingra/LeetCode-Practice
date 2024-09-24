class Solution {
    public String reorderSpaces(String text) 
    {
        StringBuffer sb = new StringBuffer("");
        int count = 0;
        int i = 0;
        
        while( i < text.length() )
        {
            if( text.charAt(i) == ' ' )
            {
                count++;
            }
            i++;
        }
        if( count == 0 )
        {
            return text;
        }
        String[] str = text.trim().split("\\s+");
        
        if( str.length == 1 )
        {
            sb.append(str[0]);
            for( i = 1 ; i <= count ; i++ )
            {
                sb.append(" ");                
            }
            return sb.toString();
        }
        
        int spacesAtEnd = count % (str.length - 1);
        int spcaesInBetween = count / (str.length-1);
        System.out.println(spcaesInBetween);
        for( i = 0 ; i < str.length - 1 ; i++ )
        {
            sb.append(str[i]);
            for( int j = 1 ; j <= spcaesInBetween ; j++ )
            {
                sb.append(" ");
            }
        }
        sb.append(str[str.length-1]);
        for( i = 1 ; i <= spacesAtEnd ; i++ )
        {
            sb.append(" ");
        }
        return sb.toString();
        
    }
}
