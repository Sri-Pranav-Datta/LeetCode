class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n) {
            int correct = nums[i] - 1;
            if (nums[i] <= n && nums[i] > 0 && nums[i] != nums[correct]) {
                swap(nums, correct, i);
            }
            else {
                i++;
            }
        }
        for(i = 0; i < n; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}