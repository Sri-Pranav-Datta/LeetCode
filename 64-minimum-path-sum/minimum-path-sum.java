class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[]row : dp) Arrays.fill(row, -1);
        f(n-1, m-1, dp, grid);
        return dp[n-1][m-1];
    }
    int f(int i, int j, int[][] dp, int[][] grid) {
        if( i == 0 && j == 0) return dp[i][j] = grid[i][j];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];
        int up = f(i-1,j,dp,grid);
        int down =f(i, j-1, dp, grid);
        int mini = Math.min( up == Integer.MAX_VALUE ? Integer.MAX_VALUE : grid[i][j] + up,down == Integer.MAX_VALUE ? Integer.MAX_VALUE : grid[i][j] + down );
        return dp[i][j] = mini;
    }
}