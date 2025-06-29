class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                if(i == j) {
                    dist[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int d = edges[i][1];
            int w = edges[i][2];
            dist[s][d] = w;
            dist[d][s] = w;
        }
        // floydd warshall algorithm for shortest path from every node to another node
        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        int minneigh = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if(minneigh >= count) {
                minneigh = count;
                res = i;
            }
        }
        return res;
    }
}