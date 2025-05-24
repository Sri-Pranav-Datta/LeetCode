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
    public int maxPathSum(TreeNode root) {
        int res[] = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPath(root, res);
        return res[0];
    }
    int maxPath(TreeNode root, int[] res) {
        if(root == null) return 0;

        int l = maxPath(root.left, res);
        if(l < 0) l = 0;
        int r = maxPath(root.right, res);
        if(r < 0) r = 0;
        res[0] = Math.max(res[0], root.val + l + r);
        return root.val + Math.max(l,r);
    }
}