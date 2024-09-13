class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            for(int j=queries[i][0]; j<=queries[i][1];j++){
                result[i] = result[i]^arr[j];
            }
        }
        return result;
    }
}