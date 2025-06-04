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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode temp = root;
        if(root ==null) return node;
        while(temp != null) {
            if(temp.val < val) {
                if(temp.right != null) temp = temp.right;
                else {
                    temp.right = node;
                    break;
                }
            }
            else {
                if(temp.left != null) temp = temp.left;
                else {
                    temp.left = node;
                    break;
                }
            }
        }
        return root;
    }
}