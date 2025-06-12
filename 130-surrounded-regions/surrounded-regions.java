class Solution {
    void dfs(int i, int j, char[][] board, boolean visited[][], int delrow[], int delcol[]) {
        int m = board.length;
        int n = board[0].length;
        visited[i][j] = true;
        for(int p = 0; p < 4; p++) {
            int nr = i + delrow[p];
            int nc = j + delcol[p];
            if(nr>=0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O' && !visited[nr][nc]) {
                dfs(nr,nc,board,visited,delrow,delcol);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        //traverse boundary rows
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j, board, visited, delrow, delcol);
            }
            if(board[m-1][j] == 'O' && !visited[m-1][j]) {
                dfs(m-1, j, board, visited, delrow, delcol);
            }
        }
        //traverse boundary columns
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, board, visited, delrow, delcol);
            }
            if(board[i][n-1] == 'O' && !visited[i][n-1]) {
                dfs(i, n-1, board, visited, delrow, delcol);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}