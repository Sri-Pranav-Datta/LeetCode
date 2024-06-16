class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int result=0;
        if(n==1){
            return nums[0];
        }
        // for(int i=0 ; i < n-1 ; i++){
        //     result+= nums[i]^nums[i+1];
        //     nums[i+1] = result;
        // }
        return xor(nums, result, 0, n);
    }
    int xor(int[] nums, int res, int p, int n){
        if(p==0){
            res = nums[0]^nums[1];
        }
        else if(p==n-1){
            return res;
        }
        else{
            res = res^nums[p+1];
        }
        
        return xor(nums, res, p+1, n);
    }
}