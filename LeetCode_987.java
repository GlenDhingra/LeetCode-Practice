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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ){
            return res;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queueTree = new LinkedList<>();
        Queue<Integer> queueInt = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        queueTree.offer(root);
        queueInt.offer(0);
        while( !queueTree.isEmpty() ){
            int size = queueTree.size();
            HashMap<Integer, List<Integer>> tMap = new HashMap<>();
            for( int i = 0 ; i < size ; i++ ){
                TreeNode node = queueTree.poll();
                int index = queueInt.poll();
                
                tMap.putIfAbsent(index, new ArrayList<Integer>());
                List<Integer> temp = tMap.get(index);
                temp.add(node.val);
                tMap.put(index, temp);
                min = Math.min(index, min);
                max = Math.max(index, max);

                if( node.left != null ){
                    queueTree.offer(node.left);
                    queueInt.offer(index-1);
                }
                if( node.right != null ){
                    queueTree.offer(node.right);
                    queueInt.offer(index+1);
                }
            }
            
            for( Map.Entry<Integer, List<Integer>> entry: tMap.entrySet() ){
                int index = entry.getKey();
                List<Integer> valueList = entry.getValue();
                Collections.sort(valueList);
                map.putIfAbsent(index, new ArrayList<Integer>());
                List<Integer> temp = map.get(index);
                temp.addAll(valueList);
                map.put(index, temp);
            }
        }
        for( int i = min ; i <= max ; i++ ){
            List<Integer> temp = map.get(i);
            res.add(temp);
        }
        return res;
    }
}