class Solution {
    public int missingNumber(int[] nums) {
        int n  = nums.length;
        for(int i = 0; i <= n; i++){
            boolean flag = false;
            for(int j = 0; j < n; j++) {
                if(nums[j]==i) {
                    flag = true;
                }
            }
            if(flag == false) {
                return i;
            }
        }
        return n;
    }
}