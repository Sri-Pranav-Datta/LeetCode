class Pair {
    int node;
    int c;

    public Pair(int node, int c) {
        this.node = node;
        this.c = c;
    }
}

class Solution {
    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<Integer>[] tree = new ArrayList[n];
        for(int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }
        //dfs to get to all nodes
        // boolean[] visited = new boolean[n];
        // List<Integer> leafCosts = new ArrayList<>();
        // Stack<Pair> stack = new Stack<>();
        // visited[0] = true;
        // stack.push(new Pair(0,cost[0]));
        // while(!stack.isEmpty()) {
        //     Pair p = stack.pop();
        //     int node = p.node;
        //     int c = p.c;
        //     boolean isLeaf = true;
        //     for(int it : tree[node]) {
        //         if(!visited[it]) {
        //             visited[it] = true;
        //             stack.push(new Pair(it, c + cost[it]));
        //             isLeaf = false;
        //         }
        //     }
        //     if(isLeaf) {
        //         leafCosts.add(c);
        //     }
        // }
        // int maxi = 0;
        // for(int i = 0; i < leafCosts.size(); i++) {
        //     maxi = Math.max(leafCosts.get(i), maxi);
        // }

        
        int[] result = new int[1];
        dfs(0, -1, cost, tree, result);
        return result[0];
    }
    long dfs(int child, int parent, int[] cost, List<Integer>[] tree, int[]result) {
        List<Long> childSums = new ArrayList<>();
        for(int it : tree[child]) {
            // sum of all child paths
            if(it == parent) continue;
            long childSum = dfs(it, child, cost, tree, result);
            childSums.add(childSum);
        }
        if(childSums.size() == 0) {
            //this is a leaf node
            return cost[child];
        }
        long maxi = 0;
        for(int i = 0; i < childSums.size(); i++) {
            maxi = Math.max(childSums.get(i), maxi);
        }
        for(int i = 0; i < childSums.size(); i++) {
            if(childSums.get(i) != maxi) {
                result[0]++;
            }
        }
        return maxi + cost[child];
    }
}