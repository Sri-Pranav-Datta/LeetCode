class Solution {
    public int splitArray(int[] nums, int k) {
        int n =nums.length;
        int start=0, end=0, mid=0;
        for(int i=0;i<n;i++){
            start=Math.max(start,nums[i]);
            end+=nums[i];
        }
        while(start<end){
            mid = start +(end-start)/2;
            int sum =0;
            int pieces =1;
            for(int num : nums){
                if(num+sum>mid){
                    sum = num;
                    pieces++;
                }
                else{
                    sum+=num;
                }
            }
            if(pieces<=k){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return end;
    }
}