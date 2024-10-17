/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Integer> set = new HashSet<>();
        set.add(p.val);
        while( p.parent != null ){
            p = p.parent;
            set.add(p.val);
        }
        if( set.contains(q.val) ){
            return q;
        }
        while( q.parent != null ){
            q = q.parent;
            if( set.contains(q.val) ){
                return q;
            }
        }
        return p;
    }
}