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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int[] idx = {0};
        return constructBST(Integer.MAX_VALUE, preorder, idx);
    }
    TreeNode constructBST( int up, int[] preorder, int[] idx) {
        if(preorder.length == idx[0] || preorder[idx[0]] > up) return null;
        TreeNode node = new TreeNode(preorder[idx[0]]);
        idx[0]++;
        node.left = constructBST(node.val, preorder, idx);
        node.right = constructBST(up, preorder, idx); 
        return node;       
    }
}