class Solution {
    boolean dfs(int start, int c, int[][] graph, int[] color) {
        color[start] = c;

        for(int i : graph[start]) {
            if(color[i] == -1) {
                if(dfs(i, 1-c, graph, color) == false) return false;
            }
            else if(color[i] == c) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        for(int i = 0; i < v; i++) {
            color[i] = -1;
        }
        for(int i = 0; i < v; i++) {
            if(color[i] == -1) {
                if(dfs(i, 0, graph, color) == false) return false;
            }
        }
        return true;
    }
}