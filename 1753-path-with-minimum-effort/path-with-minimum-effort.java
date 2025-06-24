class Tuple {
    int cost;
    int row;
    int col;

    public Tuple(int cost, int row, int col) {
        this.cost = cost;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] effort = new int[n][m];
        for(int i =0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                effort[i][j] = (int) 1e9;
            }
        }
        effort[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a,b) -> a.cost - b.cost);
        pq.add(new Tuple(0,0,0));
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!pq.isEmpty()) {
            Tuple node = pq.poll();
            int curEff = node.cost;
            int curR = node.row;
            int curC = node.col;
            if(curR == n-1 && curC == m-1) return curEff;
            for(int i = 0; i < 4; i++) {
                int newR = curR + dr[i];
                int newC = curC + dc[i];
                if(newR >= 0 && newR < n && newC>= 0 && newC < m) {
                    int newEff = Math.max(Math.abs(heights[curR][curC] - heights[newR][newC]), curEff);
                    if(newEff < effort[newR][newC]) {
                        effort[newR][newC] = newEff;
                        pq.add(new Tuple(newEff,newR, newC));
                    }
                }
            }
        }
        return effort[n-1][m-1];
    }
}