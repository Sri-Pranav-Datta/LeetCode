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
    int ctr = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        if(root.left != null) {
            kthSmallest(root.left, k);
        }
        ctr++;
        if(ctr == k) {
            res = root.val;
        }
        if(root.right != null) {
            kthSmallest(root.right, k);
        }
        return res;
    }
}