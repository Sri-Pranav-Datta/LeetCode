class Solution {
    public int search(int[] nums, int target) {
        return BinarySearch(0, nums.length - 1, nums, target);
    }

    int BinarySearch(int left, int right, int[] nums, int target) {
        if (left > right) {
            return -1; 
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return BinarySearch(left, mid - 1, nums, target);
        } else {
            return BinarySearch(mid + 1, right, nums, target);
        }
    }
}
