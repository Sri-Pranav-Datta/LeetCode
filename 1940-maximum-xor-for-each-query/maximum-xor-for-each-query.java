class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int k = (1<<maximumBit) - 1;
        int[] res = new int[n];
        int curr = 0;
        for(int i = 0; i < n; i++) {
            curr^=nums[i];
            res[n-i-1] = ~curr&k;
        }
        return res;
    }
}