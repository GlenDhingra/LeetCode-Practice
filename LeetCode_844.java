class Solution 
{
    public boolean backspaceCompare(String s, String t) 
    {
        return makeString(s).equals(makeString(t));
    }
    public String makeString(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == '#')
            {
                if(sb.length() != 0) sb.deleteCharAt(sb.length()-1);
            }
            else
            {
                sb.append(s.charAt(i));
            }
        }
        return sb.reverse().toString();
    }
}