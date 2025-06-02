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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inmap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        TreeNode root = tree(preorder, 0, preorder.length -1,inmap, 0, inorder.length -1);
        return root;
    }
    TreeNode tree(int[] preorder, int prestart, int preend, Map<Integer, Integer> inmap, int instart, int inend) {
        if(prestart > preend) return null;
        if(instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = inmap.get(root.val);
        int numsleft = inroot - instart;
        root.left = tree(preorder, prestart+1, prestart+numsleft, inmap, instart, inroot -1);
        root.right = tree(preorder, prestart + numsleft + 1,preend, inmap, inroot+1, inend);
        return root;
    }
}