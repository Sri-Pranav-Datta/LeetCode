class Solution {
    public boolean search(int[] nums, int target) {
        int l=0, n= nums.length;
        int r = n-1;
        int mid;
        if(n==1 && nums[0]==target){
            return true;
        }
        while(l<=r){
            mid = l+ (r-l)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[l]==nums[mid] && nums[mid]==nums[r]){
                l++;
                r--;
                continue;
            }
            //is left subarray sorted?
            if(nums[l]<=nums[mid]){//left subarray is sorted
                if(target<=nums[mid] && target>=nums[l]){//if target lies in sorted arr
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{//right subarray is sorted
                if(target<=nums[r] && target>=nums[mid]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return false;
    }
}