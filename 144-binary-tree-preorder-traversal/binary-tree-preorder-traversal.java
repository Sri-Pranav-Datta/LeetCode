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
 //iterative approach
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        st.push(root);
        while(!st.isEmpty()) {
            root =st.pop();
            if(root.right != null) st.push(root.right);
            if(root.left != null) st.push(root.left);
            res.add(root.val);
        }
        return res;
    }
}