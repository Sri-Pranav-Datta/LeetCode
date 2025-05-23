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

    void prelev(TreeNode root, int l, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        if(res.size() == l) {
            List<Integer> sub = new ArrayList<Integer>();
            sub.add(root.val);
            res.add(sub);
        }
        else {
            res.get(l).add(root.val);
        }
        prelev(root.left, l+1, res);
        prelev(root.right, l+1, res);
    } 
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        prelev(root, 0, res);
        return res;
    }

}