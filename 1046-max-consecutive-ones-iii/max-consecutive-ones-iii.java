class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int maxi = 0;
        int curr = 0;
        Queue<Integer> q = new LinkedList<>();
        while(r < n) {
            if(nums[r] == 0) {
                q.add(r);
            }
            if(q.size() > k ) {
                    l = q.poll() + 1;
            }
            curr = r-l + 1;
            maxi = Math.max(curr, maxi);
            r++;
        }
        return maxi;
    }
}