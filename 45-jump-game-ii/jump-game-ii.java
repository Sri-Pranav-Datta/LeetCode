class Solution {
    public int jump(int[] nums) {
        int jumps=0, l=0, r =0;
        int n = nums.length;
        while(r < n-1) {
            int farthest = 0;
            for(int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            l =r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}