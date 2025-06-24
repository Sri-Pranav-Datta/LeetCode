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
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] cost = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j =0; j < n; j++) {
                cost[i][j] = (int) 1e9;
            }
        }
        Queue<Tuple> q = new LinkedList<>();
        int[] dr = {-1, 0, 1};
        int[] dc = {-1, 0, 1};
        if(grid[0][0] == 1) return -1;
        q.offer(new Tuple(0,0,0));
        cost[0][0] = 0;
        while(!q.isEmpty()) {
            Tuple node = q.poll();
            int currCost = node.cost;
            int currRow = node.row;
            int currCol = node.col;
            for(int diffr : dr) {
                for(int diffc : dc) {
                    if(diffr == 0 && diffc == 0) {
                        continue;
                    }
                    int newR = currRow + diffr;
                    int newC = currCol + diffc;
                    int newCost = currCost+1;
                    if(newR >= 0 && newR < n && newC >=0 && newC < n && grid[newR][newC] == 0 && newCost < cost[newR][newC]) {
                        cost[newR][newC] = newCost;
                        q.offer(new Tuple(newCost, newR, newC));
                    }
                }
            }
        }
        if(cost[n-1][n-1] == 1e9) return -1;
        else return cost[n-1][n-1] + 1;
    }
}