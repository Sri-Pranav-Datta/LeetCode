class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        int mid;
        while(l<r){
            mid = l+ (r-l)/2;
            if(nums[mid+1]<nums[mid]){
                r = mid;
            }
            else{
                l =mid+1;
            }
        }
        return l;
    }
}