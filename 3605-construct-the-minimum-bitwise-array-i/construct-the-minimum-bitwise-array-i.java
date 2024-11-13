class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int res = -1;
            for(int j = 0; j < nums.get(i); j++) {
                if((j | (j + 1)) == nums.get(i)) {
                    res = j;
                    break;
                }
            }
            ans[i] = res;
        }
        return ans;
    }
}