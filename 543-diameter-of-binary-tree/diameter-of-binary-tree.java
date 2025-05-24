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
    public int diameterOfBinaryTree(TreeNode root) {
        int res[] = new int[1];
        height(root, res);
        return res[0];
    }
    int height(TreeNode root, int[] res) {
        if(root == null) return 0;

        int l = height(root.left, res);
        int r = height(root.right, res);
        if(res[0] < l+r) res[0] = l+r;
        return 1+ Math.max(l,r);
    }
}