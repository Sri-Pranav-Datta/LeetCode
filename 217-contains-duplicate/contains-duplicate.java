class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i+1]==nums[i]){
                return true;
            }
        }
        return false;
    }
}