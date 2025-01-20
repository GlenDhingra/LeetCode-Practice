class TimeMap {
    HashMap<String, ArrayList<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair<Integer, String>> curr;
        if( map.containsKey(key) ){
            curr = map.get(key);
        }
        else{
            curr = new ArrayList<>();
        }
        curr.add(new Pair<>(timestamp, value));
        map.put(key, curr);
    }
    
    public String get(String key, int timestamp) {
        if( !map.containsKey(key) ){
            return "";
        }
        ArrayList<Pair<Integer, String>> curr = map.get(key);
        if( timestamp < curr.get(0).getKey() ){
            return "";
        }
        int low = 0;
        int high = curr.size();

        while( low < high ){
            int mid = (low + high) / 2;
            if( curr.get(mid).getKey() <= timestamp ){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        if( high == 0 ){
            return "";
        }
        return curr.get(low-1).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */