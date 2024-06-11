class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i; j<n; j++){
                if(nums[i]==nums[j] && i<j){
                    count++;
                }
            }
        }
        return count;
    }
}