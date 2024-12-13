class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        for(j = 1; j < n; j++) {
            if(nums[i] == nums[j]) {
                continue;
            }
            else if (i +1 != j) {
                i++;
                nums[i] = nums[j];
            }
            else {
                i++;
            }
        }
        return i+1;
    }
}