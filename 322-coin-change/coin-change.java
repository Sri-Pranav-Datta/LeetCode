class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        int ans = f(n-1, amount, dp, coins);
        if(ans >= (int) 1e9) {
            return -1;
        }
        return ans;
        
    }
    int f(int i, int t, int[][] dp, int[] coins) {
        if(i == 0) {
            if(t % coins[0] == 0) return dp[i][t] = t / coins[0];
            else return dp[i][t] = (int)1e9;
        }
        if(dp[i][t] != -1) return dp[i][t];
        int notTake = f(i - 1, t, dp, coins);
        int take =(int) 1e9;
        if(coins[i] <= t) {
            take = 1 + f(i, t-coins[i], dp, coins);
        }
        return dp[i][t] = Math.min(notTake, take);
    } 
}