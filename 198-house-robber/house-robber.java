class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        helper(nums, dp, n-1);
        return dp[n-1];
    }
    int helper(int[] nums, int[] dp, int i) {
        if(i == 0) return dp[0] = nums[0];
        if(i < 0) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = nums[i] + helper(nums, dp, i-2);
        int notpick =  helper(nums, dp, i-1);
        dp[i] = Math.max(pick, notpick);
        return dp[i];
    }
}