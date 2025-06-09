class Pair {
    int r;
    int c;
    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class Solution {
    void bfs(Pair p, char[][] grid, boolean[][] visited) {
        int i = p.r;
        int j = p.c;
        visited[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int delrow = -1; delrow <=1; delrow++) {
            for(int delcol = -1; delcol <=1 ; delcol++) {
                if (Math.abs(delrow) + Math.abs(delcol) != 1) continue;
                int row = i + delrow;
                int col = j + delcol;
                if(row >= 0 && row <n && col >=0 && col < m && grid[row][col] == '1' && !visited[row][col]) {
                    visited[row][col] = true;
                    bfs(new Pair(row, col), grid, visited);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    bfs(new Pair(i, j), grid, visited);
                } 
            }
        }
        return res;
    }
}