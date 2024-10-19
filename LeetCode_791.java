class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder(s);
        for( int i = order.length() - 1 ; i >= 0 ; i-- ){
            char c = order.charAt(i);
            int count = 0;
            while( sb.indexOf(c+"") != -1 ){
                int index = sb.indexOf(c+"");
                sb.deleteCharAt(index);
                count++;
            }
            while( count > 0 ){
                sb.insert(0,c);
                count--;
            }
        }
        return sb.toString();
    }
}