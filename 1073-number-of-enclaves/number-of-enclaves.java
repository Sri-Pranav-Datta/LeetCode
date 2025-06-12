
class Solution {
    void dfs(int i, int j, int[][] grid, boolean visited[][], int delrow[], int delcol[]) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        for(int p = 0; p < 4; p++) {
            int nr = i + delrow[p];
            int nc = j + delcol[p];
            if(nr>=0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr,nc,grid,visited,delrow,delcol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        //traverse boundary rows
        for(int j = 0; j < m; j++) {
            if(grid[0][j] == 1 && !visited[0][j]) {
                dfs(0, j, grid, visited, delrow, delcol);
            }
            if(grid[n-1][j] == 1 && !visited[n-1][j]) {
                dfs(n-1, j, grid, visited, delrow, delcol);
            }
        }
        //traverse boundary columns
        for(int i = 0; i < n; i++) {
            if(grid[i][0] == 1 && !visited[i][0]) {
                dfs(i, 0, grid, visited, delrow, delcol);
            }
            if(grid[i][m-1] == 1 && !visited[i][m-1]) {
                dfs(i, m-1, grid, visited, delrow, delcol);
            }
        }
        int count = 0;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
