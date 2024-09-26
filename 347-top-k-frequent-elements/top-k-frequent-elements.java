class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] freq = new ArrayList[n+1];
        for(int i=0; i< n+1; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> set: map.entrySet()){
            int f = set.getValue();
            freq[f].add(set.getKey());
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i=freq.length -1; i>=0; i--){
            for(int num: freq[i]) {
                res[idx++] = num;
                if(idx ==k) {
                    return res;
                }
            }
        }
        return new int[0];
    }
}