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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightView(root, 0, res);
        return res;
    }
    void rightView(TreeNode root, int level, List<Integer> res) {
        if(root == null) {
            return;
        }
        if(res.size()==level) {
            res.add(root.val);
        }
        if(root.right != null) rightView(root.right, level+1, res);
        if(root.left != null) rightView(root.left, level+1, res);
    }
}