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

class Pair {
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<Pair>();
        int res = 0;
        queue.offer(new Pair(root,0));
        int last = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            int curmin = queue.peek().index;
            int j = 0;
            for(int i = 0; i < n; i++) {
                Pair curr = queue.poll();
                j = curr.index - curmin;
                if(curr.node.left != null) queue.offer(new Pair(curr.node.left, 2*j + 1));
                if(curr.node.right != null) queue.offer(new Pair(curr.node.right, 2*j + 2));
            }
            res = Math.max(res, j+1);
        }
        return res;
    }
}