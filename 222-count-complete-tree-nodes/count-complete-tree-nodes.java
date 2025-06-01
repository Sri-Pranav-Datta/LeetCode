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
    public int countNodes(TreeNode root) {
         if(root == null) return 0;

        TreeNode temp = root;
        int l =0;
        int r =0;
        while(temp != null) {
            temp = temp.left;
            l++;
        }
        int res = 0;
        temp = root;
        while(temp!=null) {
            temp = temp.right;
            r++;
        }
        if(l == r) {
            res = (1<<(l)) -1;
        }
        else {
            res = 1 + countNodes(root.left) + countNodes(root.right);
        }
        return res;
    }
}