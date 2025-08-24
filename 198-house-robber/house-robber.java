class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 1; i < n; i++) {
            int take = nums[i];
            if(i > 1) take+= prev2;
            int nottake = prev;
            int cur = Math.max(take, nottake);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}