class Solution {
    private int countWays(int n, int[] dp) {
        if(dp[n] != -1) return dp[n];
        int l = countWays(n-1, dp);
        int r = countWays(n-2, dp);
        dp[n] = l + r;
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        return countWays(n, dp);
    }
}