class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] setBits = new int[n]; 
        for(int i = 0; i < n; i++) {
            setBits[i] = setBit(nums[i]);
        }
        int maxi = nums[0];
        int prevMax = 0;
        int min = nums[0];
        for(int i = 1; i < n; i++) {
            if(setBits[i]==setBits[i-1]) {
                maxi = Math.max(nums[i],maxi);
                min = Math.min(nums[i],min);
            }
            else {
                if(prevMax <= min){
                    prevMax = maxi;
                    maxi = nums[i];
                    min = nums[i];
                }else {
                    return false;
                }
            }
        }
        if(prevMax > min) {
            return false;
        }
        return true;
    }
    static int setBit(int num) {
        int res = 0;
        while(num > 0) {
            res += num & 1;
            num = num>>1;
        }
        return res;
    }
}