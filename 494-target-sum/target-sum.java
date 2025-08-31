class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        for(int i = 0; i < n; i++) {
            s+=nums[i];
        }
        int t = (s-target);
        if(t < 0 || t%2 != 0) return 0;
        t = t/2;
        int[][] dp = new int[n][t+1];
        for(int[] rows : dp) Arrays.fill(rows, -1);
        return f(n-1, t, dp, nums);
    }
    int f(int i, int t, int[][] dp, int[] nums) {
        if(i == 0) {
            if(nums[i] == 0 && t == 0) return 2;
            if(nums[i]  == t|| t == 0) return 1;
            else return 0;
        }
        if(dp[i][t] != -1) return dp[i][t];
        int notpick = f(i-1, t, dp, nums);
        int pick = 0;
        if(nums[i] <= t) {
            pick = f(i-1, t - nums[i], dp, nums);
        }
        return dp[i][t] = pick + notpick;
    }
}