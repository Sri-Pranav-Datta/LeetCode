class Solution {
    private void recursiveFunc(int idx, int[] nums, List<Integer> sub, List<List<Integer>> res) {
    if (idx == nums.length) {
        res.add(new ArrayList<>(sub));  // Add a copy of current subset
        return;
    }

    // Take the element at idx
    sub.add(nums[idx]);
    recursiveFunc(idx + 1, nums, sub, res);

    // Don't take the element
    sub.remove(sub.size() - 1);
    recursiveFunc(idx + 1, nums, sub, res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        List<Integer> sub = new ArrayList<>();
        //res.add(sub);
        recursiveFunc(0, nums,sub, res);
        return res;
    }
}