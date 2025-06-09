class Solution {
    void dfs(Integer Node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[Node] = true;
        for(Integer it : adj.get(Node)) {
            if(!visited[it]) {
                dfs(it, visited, adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int n = isConnected.length;
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                res++;
                dfs(i, visited, adj);
            }
        }
        return res;
    }
}