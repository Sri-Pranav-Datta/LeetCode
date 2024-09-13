class Solution {
    public int search(int[] nums, int target) {
        return modBS(nums,0,nums.length-1,target);
    }
    public int modBS(int[] nums, int l, int r, int target){
        if(l==r){
            if(nums[l] == target){
                return l;
            }
            else{
                return -1;
            }
        }
        int mid = l+ (r-l)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[l]<=nums[mid]){//left subarray is sorted
            if(nums[l]<=target && target<=nums[mid]){
                //answer is in left subarray
                return modBS(nums,l,mid-1,target);
            }
            else{
                //answer is in right subarray
                return modBS(nums,mid+1,r,target);
            }
        }
        else{
            if(nums[mid]<=target && target<= nums[r]){
                return modBS(nums,mid+1,r,target);
            }
        }
        return modBS(nums,l,mid-1,target);
    }
}