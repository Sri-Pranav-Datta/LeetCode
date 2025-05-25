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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return res;
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> sub = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
                if(flag) {
                    sub.add(temp.val);
                }else {
                    sub.addFirst(temp.val);
                }
            }
            flag = !flag;
            res.add(sub);
        }
        return res;
    }
}