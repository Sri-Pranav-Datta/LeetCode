class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int i = 0;
        while(i < n) {
            if(nums[i] != n && nums[i] != nums[nums[i]]) {
                swap(nums,i,nums[i]);
                
            }
            else {
                i++;
            }
        }
        for(i = 0; i < n; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}