class Solution {
    public String restoreString(String s, int[] indices) 
    {
        char[] c = new char[indices.length];
        for( int i = 0 ; i < indices.length ; i++ )
        {
            int index = indices[i];
            c[index] = s.charAt(i);
        }
        return String.valueOf(c);
    }
}