class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] arr = {-1,-1};
        if(n==0){
            return arr;
        }
        arr[0] = binarySearch1(nums,target,0,n-1);
        arr[1] = binarySearch2(nums,target,0,n-1);
        return arr;
    }
    public int binarySearch1(int[]nums, int target, int l, int r){
        if(l>r){
            return -1;
        }
        int mid = l+ (r-l)/2;
        if(nums[mid]== target ){
            if(mid==0 || nums[mid-1]!= target){
                return mid;
            }
            else{
                return binarySearch1(nums,target,l,mid-1);
            } 
        }
        if(nums[mid]> target){//search left if mid is greater
            return binarySearch1(nums,target,l,mid-1);
        }
        if(nums[mid]<target){//search right otherwise
            return binarySearch1(nums,target,mid+1,r);
        }
        return -1;
    }
    public int binarySearch2(int[]nums, int target, int l, int r){
        if(l>r){
            return -1;
        }
        int mid = l+ (r-l)/2;
        if(nums[mid]== target ){
            if(mid==nums.length-1 || nums[mid+1]!=target){
                return mid;
            }
            else{
                return binarySearch2(nums,target,mid+1,r);
            }
        }
        if(nums[mid]<target){
            return binarySearch2(nums,target,mid+1,r);
        }
        if(nums[mid]>target){
            return binarySearch2(nums,target,l,mid-1);
        }
        return -1;
    }
}