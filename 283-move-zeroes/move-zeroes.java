class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int[] newarr = nums;
        int count=0;
        for(int i=0;i<n;i++){
            if(newarr[i]!=0){
                nums[count++]=newarr[i];
            }
        }
        for(int i=count; i<n;i++ ){
            nums[count++]=0;
        }
    }
}