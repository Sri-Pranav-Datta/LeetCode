class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //f(dp, m-1, n-1);
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( i == 0 && j == 0) continue;
                int up = 0;
                int left = 0;
                if(i >= 1) up = dp[i-1][j];
                if(j >= 1) left = dp[i][j-1];
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }
    int f(int[][] dp, int r, int c) {
        if(r == 0 && c == 0) return dp[r][c] = 1;
        if(r < 0 || c < 0) return 0;
        if(dp[r][c] != 0) return dp[r][c];
        int up = f(dp, r-1, c);
        int left = f(dp, r, c-1);
        return dp[r][c] = up + left;
    }
}