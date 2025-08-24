class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int prev = nums[0];
        int prev2 = 0;
        // including 1st index, so we cant include last
        for(int i = 1; i < n-1; i++) {
            int take = nums[i] + prev2;
            int nottake = prev;
            int cur = Math.max(take, nottake);
            prev2 = prev;
            prev = cur;
        }
        int included = prev;
        //not including 1st index, so we can possibly include last
        prev = nums[1];
        prev2 = 0;
        for(int i = 2; i < n; i++) {
            int take = nums[i]+prev2;
            int nottake = prev;
            int cur = Math.max(take, nottake);
            prev2 = prev;
            prev = cur;
        }
        int notincluded = prev;
        return Math.max(included, notincluded);
    }
}