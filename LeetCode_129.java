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
    public int sumNumbers(TreeNode root) {
        Queue<Integer> queueInt = new LinkedList<>();
        Queue<TreeNode> queueTree = new LinkedList<>();
        queueTree.offer(root);
        queueInt.offer(root.val);
        int sum = 0;
        while( !queueTree.isEmpty() ){
            TreeNode node = queueTree.poll();
            int num = queueInt.poll();
            if( node.left == null && node.right == null ){
                sum += num;
            }
            if( node.left != null ){
                int leftNum = node.left.val;
                int copy = num;
                copy *= 10;
                copy += leftNum;
                queueTree.offer(node.left);
                queueInt.offer(copy);
            }
            if( node.right != null ){
                int rightNum = node.right.val;
                int copy = num;
                copy *= 10;
                copy += rightNum;
                queueTree.offer(node.right);
                queueInt.offer(copy);
            }
        }
        return sum;
    }
}