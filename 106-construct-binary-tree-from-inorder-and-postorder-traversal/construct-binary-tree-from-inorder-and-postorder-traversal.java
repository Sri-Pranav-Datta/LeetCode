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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inmap = new HashMap<>();
        int n = inorder.length;
        for(int  i= 0; i < n; i++) {
            inmap.put(inorder[i], i);
        }
        return tree(postorder, 0, n-1, inmap, 0, n-1);
    }
    TreeNode tree(int[] postorder, int posts, int poste, Map<Integer, Integer> inmap, int ins, int ine) {
        if(posts > poste || ins > ine) return null;
        TreeNode root = new TreeNode(postorder[poste]);
        int inroot = inmap.get(root.val);
        int left = inroot- ins;
        root.left = tree(postorder, posts, posts+left-1, inmap, ins, inroot -1);
        root.right = tree(postorder, posts + left, poste -1, inmap, inroot+1, ine);
        return root;
    }
}