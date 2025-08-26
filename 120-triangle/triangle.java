class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                dp.get(i).add(-1);
            }
        }
        
        dp.get(0).set(0, triangle.get(0).get(0)); 
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp.get(i).set(j, triangle.get(i).get(j) + dp.get(i-1).get(j));
                } 
                else if (j == i) {
                    dp.get(i).set(j, triangle.get(i).get(j) + dp.get(i-1).get(j-1));
                } 
                else {
                    int left = triangle.get(i).get(j) + dp.get(i-1).get(j-1);
                    int right = triangle.get(i).get(j) + dp.get(i-1).get(j);
                    dp.get(i).set(j, Math.min(left, right));
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp.get(n-1).get(j));
        }
        return res;
    }
}
