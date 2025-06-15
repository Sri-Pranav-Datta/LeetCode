class Solution {
    boolean check(int node, int[][] graph, boolean[] visited, boolean[] path, boolean[] safe) {
        visited[node] = true;
        path[node] = true;
        safe[node] = false;

        for(int it : graph[node]) {
            if(!visited[it] && check(it, graph, visited, path, safe) == true) return true;

            if(visited[it] && path[it]){
                return true;
            } 
        }
        path[node] = false;
        safe[node] = true;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        boolean[] path = new boolean[v];
        boolean safe[] = new boolean[v];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                check(i, graph, visited, path, safe);
            }
        }
        for(int i = 0; i < v; i++) {
            if(safe[i]) res.add(i);
        }
        return res;
    }
}