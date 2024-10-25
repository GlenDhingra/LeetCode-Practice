class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for( int i = 0 ; i < words.length - 1 ; i++ ){
            String current = words[i];
            String next = words[i+1];

            int i1 = 0;
            int j1 = 0;
            
            while( i1 < current.length() && j1 < next.length() && current.charAt(i1) == next.charAt(j1) ){
                i1++;
                j1++;
            }
            if( i1 < current.length() && j1 == next.length() ){
                return false;
            }
            if( i1 == current.length() ) continue;
            char first = current.charAt(i1);
            char second = next.charAt(j1);

            if( order.indexOf(second) < order.indexOf(first) ){
                return false;
            }
        }
        return true;
    }
}