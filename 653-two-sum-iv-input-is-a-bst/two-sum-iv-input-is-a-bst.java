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
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse = true;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushall(root);
    }
    public int next() {
        TreeNode temp = stack.pop();
        if(reverse == false) pushall(temp.right);
        else pushall(temp.left);
        return temp.val;
    }
    void pushall(TreeNode node) {
        while(node != null) {
            stack.push(node);
            if(reverse == false) node = node.left;
            else node = node.right;
        }
    }
} 
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator i = new BSTIterator(root, false);
        BSTIterator d = new BSTIterator(root, true);
        int p = i.next();
        int q = d.next();
        while(p < q) {
            if(p + q == k) return true;
            if(p + q < k) p = i.next();
            else q = d.next();
        }
        return false;
    }
}