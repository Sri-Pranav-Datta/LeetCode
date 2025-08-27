class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }
        int[] dir = {-1,0,1};
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int mini = Integer.MAX_VALUE;
                for(int k : dir) {
                    if(j + k < 0 || j + k >= m) continue;
                    mini = Math.min(mini, dp[i-1][j+k] + matrix[i][j]);
                }
                dp[i][j] = mini;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            res = Math.min(res, dp[n-1][j]);
        }
        return res;
    }
}