class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int s=0;
        for(int i = 0; i < n; i++) {
            s+=nums[i];
        }
        if(s%2 != 0) return false;
        s = s/2;
        int[][] dp = new int[n][s+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return f(n-1, s, dp, nums);
    }
    boolean f(int i, int s, int[][] dp, int[] nums) {
        if(s == 0) return true;
        if(nums[i] == s) return true;
        if(i == 0 ) return false;

        if(dp[i][s] != -1) return dp[i][s] == 1;
        boolean take = false;
        if(nums[i] <= s) {
            take = f(i-1, s-nums[i], dp, nums);
        }
        boolean nottake = f(i-1, s, dp, nums);
        if(take || nottake) {
            dp[i][s] = 1;
        }
        else {
            dp[i][s] = 0;
        }
        return dp[i][s] == 1;
    }
}