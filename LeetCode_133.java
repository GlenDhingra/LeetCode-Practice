/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if( node == null ){
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        dfs(node, newNode, map);
        return newNode;
    }
    public void dfs( Node node, Node newNode, HashMap<Integer, Node> map ){
        List<Node> children = new ArrayList<>();
        for( int i = 0 ; i < node.neighbors.size() ; i++ ){
            Node currChild = node.neighbors.get(i);
            if( map.containsKey(currChild.val) ){
                children.add(map.get(currChild.val));
            }
            else{
                Node childNode = new Node(currChild.val);
                children.add(childNode);
                map.put(childNode.val, childNode);
                dfs(currChild, childNode, map);
            }
        }
        newNode.neighbors = children;
    }
}