class TrieNode{
    char obj;
    ArrayList<TrieNode> children;
    boolean isLast = false;

    public TrieNode( char obj, ArrayList<TrieNode> children, boolean isLast ){
        this.obj = obj;
        this.children = children;
        this.isLast = isLast;
    }
    public char getObj(){
        return obj;
    }
    public ArrayList<TrieNode> getChildren(){
        return children;
    }
    public boolean getIsLast(){
        return isLast;
    }
    public void setObj(char obj){
        this.obj = obj;
    }
    public void setChildren( ArrayList<TrieNode> children ){
        this.children = children;
    }
    public void setIsLast(boolean isLast){
        this.isLast = isLast;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode(' ', new ArrayList<TrieNode>(), false);
    }
    
    public void addWord(String word) {
        if( word.length() == 0 ){
            root.setIsLast(true);
        }
        addWordHelper(word, 0, root);
    }
    public void addWordHelper( String word, int index, TrieNode node ){
        if(index == word.length()) return;
        ArrayList<TrieNode> curr = node.getChildren();
        for( int i = 0 ; i < curr.size() ; i++ ){
            char obj = curr.get(i).getObj();
            if( obj == word.charAt(index) ){
                if( index == word.length() - 1 ){
                    curr.get(i).setIsLast(true);
                    return;
                }
                addWordHelper(word, index+1, curr.get(i));
                return;
            }
        }

        boolean isLast = (index == word.length()-1) ? true : false;
        TrieNode child = new TrieNode(word.charAt(index), new ArrayList<TrieNode>(), isLast);
        curr.add(child);
        node.setChildren(curr);
        addWordHelper(word, index+1, child);
    }
    
    public boolean search(String word) {
        if( word.length() == 0 ){
            return root.getIsLast();
        }
        return searchHelper(word, 0, root);
    }
    public boolean searchHelper( String word, int index, TrieNode node ){
        if(index == word.length()){
            return node.getIsLast();
        }
        ArrayList<TrieNode> curr = node.getChildren();
        if( word.charAt(index) == '.' ){
            for( int i = 0 ; i < curr.size() ; i++ ){
                if( searchHelper(word, index+1, curr.get(i)) ){
                    return true;
                }
            }
            return false;
        }
        else{
            for( int i = 0 ; i < curr.size() ; i++ ){
                if( curr.get(i).getObj() == word.charAt(index) ){
                    return searchHelper(word, index+1, curr.get(i));
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */