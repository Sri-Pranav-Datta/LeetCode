class Tuple {
    int row;
    int col;
    int dist;

    public Tuple(int row, int col, int dist) {
        this.row= row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] res = new int[n][m];
        Queue<Tuple> q = new LinkedList<Tuple>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new Tuple(i,j,0));
                    visited[i][j] = true;
                }
                else {
                    visited[i][j] = false;
                }
            }
        }
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int d = q.peek().dist;
            q.remove();
            res[r][c] = d;
            for(int i = 0; i < 4; i++) {
                int newr = r + delrow[i];
                int newc = c + delcol[i];
                if(newr >=0 && newr < n && newc >=0 && newc < m && !visited[newr][newc]) {
                    q.offer(new Tuple(newr, newc, d + 1));
                    visited[newr][newc] = true;
                }
            }
        }
        return res;
    }
}