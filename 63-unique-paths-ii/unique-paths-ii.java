class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        if(grid[0][0] == 1) return 0;
        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0 ) continue;
                int up = 0;
                int left = 0;
                if(i > 0) up = dp[i-1][j];
                if(j > 0) left = dp[i][j-1];
                dp[i][j] = up + left;
                if(grid[i][j] == 1) dp[i][j] = 0;
            }
        }
        return dp[n-1][m-1];
    }
}