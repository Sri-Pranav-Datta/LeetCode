class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        while(i < n) {
            int correct = nums[i] - 1;
            if(nums[correct] != nums[i]) {
                swap(nums, correct, i);
            }
            else{
                i++;
            }
        }
        for(i = 0; i < n; i++) {
            if(nums[i] != i+1) {
                res.add(i+1);
            }
        }
        return res;
    }
    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}