class Solution {
    public int[] getConcatenation(int[] nums) {
        int n= nums.length;
        int[] result = new int[2*n];
        for(int i=0;i<2*n;i++){
            if(i<n){
            result[i]=nums[i];
            }
            else{
            result[i]=nums[i-n];
            }
        }
        return result;
    }
}