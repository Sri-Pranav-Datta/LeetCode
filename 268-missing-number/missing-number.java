class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int sum = (n*(n+1))/2;
        int sumarr = 0;
        for(int i=0; i<n; i++){
            sumarr+=nums[i];
        }
        return sum - sumarr;
    }
}