class Solution {
    public int change(int a, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][a+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return f(n-1, a, dp, coins);
    } 
    int f(int i, int a, int[][] dp, int[] nums) {
        if(i == 0) {
            if(a % nums[0] == 0) return 1;
            if(a == 0) return 1;
            return 0;
        }
        if(dp[i][a] != -1) return dp[i][a];
        int notpick = f(i-1, a, dp, nums);
        int pick = 0;
        if(nums[i] <= a) {
            pick = f(i, a-nums[i], dp, nums);
        }
        return dp[i][a] = pick + notpick;
    }
}