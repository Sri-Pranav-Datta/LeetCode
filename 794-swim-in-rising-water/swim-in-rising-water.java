class Tuple {
    int cost;
    int r;
    int c;
    public Tuple(int cost, int r, int c) {
        this.cost = cost;
        this.r = r;
        this.c = c;
    }
}
class Solution {
    private boolean isValid(int r, int c, int n) {
        return r>=0 && c>=0 && r<n && c<n;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // Dijkstra algorithm to track the maximum node in minimum path to the end
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Tuple(grid[0][0],0,0));
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while(!pq.isEmpty()) {
            int curtime = pq.peek().cost;
            int curr = pq.peek().r;
            int curc = pq.peek().c;
            pq.remove();
            if(curr == n-1 && curc == n-1) return curtime;
            for(int i = 0; i < 4; i++) {
                int newr = curr + dr[i];
                int newc = curc + dc[i];
                if(isValid(newr, newc, n) && !visited[newr][newc]) {
                    visited[newr][newc] = true;
                    pq.add(new Tuple(Math.max(curtime, grid[newr][newc]), newr, newc));
                }
            }
        }
        return -1;
    }
}