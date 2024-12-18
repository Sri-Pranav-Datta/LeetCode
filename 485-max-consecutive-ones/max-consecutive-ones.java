class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCon = 0;
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i]==1) {
                sum++;
                if(sum > maxCon) {
                    maxCon = sum;
                }
            }
            else {
                sum = 0;
            }
        }
        return maxCon;
    }
}