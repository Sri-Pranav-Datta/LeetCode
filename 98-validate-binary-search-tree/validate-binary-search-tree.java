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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        return isValid(root.left, Long.MIN_VALUE, root.val) & isValid(root.right, root.val, Long.MAX_VALUE);
    }
    boolean isValid(TreeNode node, long min, long max) {
        if(node == null) return true;
        if(node.val < max && node.val > min) {
            return isValid(node.left, min, node.val) & isValid(node.right, node.val, max);
        }
        return false;
    }
}