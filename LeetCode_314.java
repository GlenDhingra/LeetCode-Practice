/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ){
            return res;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queueTree = new LinkedList<>();
        Queue<Integer> queueIndex = new LinkedList<>();
        queueTree.add(root);
        queueIndex.add(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while( !queueTree.isEmpty() ){
            int size = queueTree.size();
            for( int i = 0; i < size ; i++ ){
                TreeNode node = queueTree.poll();
                int index = queueIndex.poll();
                max = Math.max(index, max);
                min = Math.min(index, min);
                map.putIfAbsent(index, new ArrayList<Integer>());
                ArrayList<Integer> temp = map.get(index);
                temp.add(node.val);
                map.put(index, temp);
                if( node.left != null ){
                    queueTree.add(node.left);
                    queueIndex.add(index-1);
                }
                if( node.right != null ){
                    queueTree.add(node.right);
                    queueIndex.add(index+1);
                }
            }
        }
        for( int i = min ; i <= max ; i++ ){
            if( map.containsKey(i) ){
                res.add(map.get(i));
            }
        }
        return res;
    }
}