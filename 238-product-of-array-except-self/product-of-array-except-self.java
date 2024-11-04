class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]*nums[i];
            suffix[n-i-1] = suffix[n-i]*nums[n-i-1];
        }
        answer[0] = suffix[1];
        answer[n-1] = prefix[n-2];
        for(int i = 1; i < n-1; i++) {
            answer[i] = prefix[i-1]*suffix[i+1];
        }
        return answer;
    }
}