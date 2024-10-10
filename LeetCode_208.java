class TrieNode{
    char obj;
    ArrayList<TrieNode> children;
    boolean isLast = false;
    public TrieNode( ArrayList<TrieNode> children, boolean isLast, char obj ){
        this.children = children;
        this.isLast = isLast;
        this.obj = obj;
    }
    public ArrayList<TrieNode> getChildren(){
        return children;
    }
    public boolean getIsLast(){
        return isLast;
    }
    public char getObj(){
        return obj;
    }
    public void setChildren( ArrayList<TrieNode> children ){
        this.children = children;
    }
    public void setIsLast( boolean isLast ){
        this.isLast = isLast;
    }
    public void setObj(char obj){
        this.obj = obj;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode( new ArrayList<TrieNode>(), false, ' ' );
    }
    
    public void insert(String word) {        
        insertHelper(word, 0, root);
    }
    public void insertHelper( String word, int index, TrieNode node ){
        ArrayList<TrieNode> curr = node.getChildren();
        for( int i = 0 ; i < curr.size() ; i++ ){
            TrieNode child = curr.get(i);
            if( child.getObj() == word.charAt(index) ){
                if( index == word.length() - 1 ){
                    child.setIsLast(true);
                    return;
                }
                insertHelper(word, index+1, child);                
                return;
            }
        } 
        boolean isLast = (index == word.length() - 1);
        TrieNode child = new TrieNode(new ArrayList<TrieNode>(), isLast, word.charAt(index));
        curr.add(child);
        if( !isLast ){
            insertHelper(word, index+1, child);
        }
    }

    public boolean search(String word) {
        if (word.isEmpty()) {
            return root.getIsLast();
        }
        return searchHelper(word, 0, root);
    }
    public boolean searchHelper( String word, int index, TrieNode node ){
        if( word.length() == index ){
            return false;
        }
        ArrayList<TrieNode> curr = node.getChildren();
        for( int i = 0 ; i < curr.size() ; i++ ){
            TrieNode child = curr.get(i);
            if( child.getObj() == word.charAt(index) ){
                if( index == word.length() - 1  ){
                    return child.getIsLast();
                }
                return searchHelper(word, index+1, child);
            }
        } 
        return false;
    }
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return true; 
        }
        return startsHelper(prefix, 0, root);
    }
    public boolean startsHelper( String word, int index, TrieNode node ){
        if( word.length() == index ){
            return false;
        }
        ArrayList<TrieNode> curr = node.getChildren();
        for( int i = 0 ; i < curr.size() ; i++ ){
            TrieNode child = curr.get(i);
            if( child.getObj() == word.charAt(index) ){
                if( index == word.length() - 1 ){
                    return true;
                }
                return startsHelper(word, index+1, child);
            }
        } 
        return false;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
