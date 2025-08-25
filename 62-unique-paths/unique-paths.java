class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //Arrays.fill(dp, -1);
        f(dp, m-1, n-1);
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