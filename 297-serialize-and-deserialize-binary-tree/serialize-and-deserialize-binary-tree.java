/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder res = new StringBuilder();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp == null) {
                res.append("n ");
            }
            else {
                res.append(temp.val + " ");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        int i = 1;
        if(nodes.length == 0 || nodes[0].equals("n")) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(!nodes[i].equals("n")) {
                temp.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(temp.left);
            }
            i++;
            if(!nodes[i].equals("n")) {
                temp.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(temp.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));