/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void updateMap(TreeNode node, Map<TreeNode, TreeNode> map) {
        if(node == null) return;

        if(node.left != null) {
            map.put(node.left, node);
            updateMap(node.left, map);
        }
        if(node.right != null) {
            map.put(node.right, node);
            updateMap(node.right, map);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        updateMap(root, parent);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        List<Integer> res = new ArrayList<>();
        int c = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            if(c >= k) break;
            for(int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                visited.put(temp, true);
                if(temp.left != null && visited.get(temp.left) == null) queue.offer(temp.left);
                if(temp.right != null && visited.get(temp.right) == null) queue.offer(temp.right);
                if(parent.get(temp) != null && visited.get(parent.get(temp)) == null) queue.offer(parent.get(temp));
            }
            c++;
            if(c >= k) break;
        }
        while(!queue.isEmpty()) {
            res.add(queue.poll().val);
        }
        return res;
    }
}