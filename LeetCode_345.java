class Solution {
    public String reverseVowels(String s) 
    {
        ArrayList<Character> list = new ArrayList();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        
        StringBuffer sb = new StringBuffer(s);
        int i = 0;
        int j = sb.length()-1;
        
        while( i < j )
        {
            while( i < j && !list.contains(sb.charAt(i)) )
            {
                i++;
            }
            while( j > i && !list.contains(sb.charAt(j)) )
            {
                j--;
            }
            System.out.println(sb.charAt(i) + " " +i + "   " + sb.charAt(j) + "  " + j );
            char c = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,c);
            i++;
            j--;
        }
        
        return sb.toString();
    }
}