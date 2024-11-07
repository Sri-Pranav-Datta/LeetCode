class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int[] count = new int[24];
        int max = 0;
        for(int i = 0; i < n; i++) {
            int pos = 0;
            while(candidates[i] > 0) {
                count[pos++]+= candidates[i]&1;
                candidates[i] = candidates[i] >> 1;
                max = Math.max(count[pos-1],max);
            }
        }
        return max;
    }
}