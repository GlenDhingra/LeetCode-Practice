class LRUCache {
    HashMap<Integer, DLL> map = new HashMap<>();
    DLL left = new DLL(-1, -1);
    DLL right = new DLL(-1,-1);
    int count = 0;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        left.nxt = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if( map.containsKey(key) ){
            DLL current = map.get(key);
            DLL previous = current.prev;
            DLL next = current.nxt;
            previous.nxt = next;
            next.prev = previous;
            DLL first = left.nxt;
            left.nxt = current;
            current.prev = left;
            current.nxt = first;
            first.prev = current;

            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if( !map.containsKey(key) ){
            DLL current = new DLL(key, value);
            DLL first = left.nxt;
            left.nxt = current;
            current.prev = left;
            current.nxt = first;
            first.prev = current;
            map.put(key, current);
            count++;

            if( count > capacity ){
                DLL last = right.prev;
                DLL sLast = last.prev;
                sLast.nxt = right;
                right.prev = sLast;
                map.remove(last.key);   
                count--;
            }
        }else{
            DLL current = map.get(key);
            current.val = value;
            DLL previous = current.prev;
            DLL next = current.nxt;
            previous.nxt = next;
            next.prev = previous;
            DLL first = left.nxt;
            left.nxt = current;
            current.prev = left;
            current.nxt = first;
            first.prev = current;
            map.put(key, current);
        }
    }
}
class DLL{
    int key, val;
    DLL prev, nxt;
    public DLL( int key, int val ){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */