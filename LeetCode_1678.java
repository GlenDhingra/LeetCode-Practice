class Solution 
{
    public String interpret(String command) 
    {
        StringBuilder sb = new StringBuilder(command);
        int index = sb.indexOf("()");
        while( index != -1 )
        {
            sb.replace(index,index + 2,"o");
            index = sb.indexOf("()");
        }
        index = sb.indexOf("(al)");
        while( index != -1 )
        {
            sb.replace(index,index+4,"al");
            index = sb.indexOf("(al)");
        }
        return sb.toString();
    }
}
/*
Replace occuance of () with o and (al) with al using stringbuilder
*/