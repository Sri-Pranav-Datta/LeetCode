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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) return helper(root);
        TreeNode dummy = root;
        while(dummy != null) {
            if(dummy.val < key) {
                if(dummy.right != null && dummy.right.val == key) {
                    dummy.right = helper(dummy.right);
                    return root;
                }
                dummy = dummy.right;
            }
            else if(dummy.val > key) {
                if(dummy.left != null && dummy.left.val == key) {
                    dummy.left = helper(dummy.left);
                    return root;
                }
                dummy = dummy.left;
            }
        }
        return root;
    }
    TreeNode helper(TreeNode node) {
        if(node.left == null) {
            return node.right;
        }
        else if(node.right == null) {
            return node.left;
        }
        TreeNode right = node.right;
        TreeNode leftofright = lefty(right);
        leftofright.left = node.left;
        return right;
    }
    TreeNode lefty(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}