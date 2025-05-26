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
class Tuple {
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap <Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.offer(new Tuple(root, 0 ,0));
        while(!queue.isEmpty()) {
            Tuple curr = queue.poll();
            TreeNode node = curr.node;
            int v = curr.vertical;
            int l = curr.level;

            if(!map.containsKey(v)) {
                map.put(v, new TreeMap<>());
            }
            if(!map.get(v).containsKey(l)) {
                map.get(v).put(l, new PriorityQueue<>());
            }
            map.get(v).get(l).offer(node.val);
            if(node.left != null) queue.offer(new Tuple(node.left, v-1, l+1));
            if(node.right != null) queue.offer(new Tuple(node.right, v+1, l+1));
        }
        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> v : map.values()) {
            List<Integer> sub = new ArrayList<Integer>();
            for(PriorityQueue<Integer> nodes : v.values()) {
                while(!nodes.isEmpty()) {
                    sub.add(nodes.poll());
                }
            }
            res.add(sub);
        }
        return res;
    }
}