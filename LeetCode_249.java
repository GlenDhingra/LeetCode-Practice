class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for( int i = 0 ; i < strings.length ; i++ ){
            String score = "";
            if( strings[i].length() == 1 ){
                score = "-1";
            }
            else{
                score = getPattern(strings[i]);            
            }
            map.putIfAbsent(score, new ArrayList<String>());
            ArrayList<String> temp = map.get(score);
            temp.add(strings[i]);
            map.put(score, temp);
        }
        for( Map.Entry<String, ArrayList<String>> entry: map.entrySet() ){
            ArrayList<String> currentList = entry.getValue();
            res.add(currentList);
        }
        return res;
    }
    public String getPattern( String s ){
        StringBuilder sb = new StringBuilder();
        for( int i = 1 ; i < s.length() ; i++ ){
            int current = ( (s.charAt(i) - '0') - (s.charAt(i-1) - '0') );
            if( current < 0 ){
                current += 26;
            }
            
            sb.append(current + "-");
        }
        return sb.toString();
    }
}
