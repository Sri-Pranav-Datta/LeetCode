class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        int x = arr.length;
        int[] prefix = new int[x];
        prefix[0]=arr[0];
        for(int i=1;i<x;i++){
            prefix[i]= prefix[i-1]^arr[i];
        }

        for(int i=0;i<n;i++){
            if(queries[i][0]==0){
                result[i] = prefix[queries[i][1]];
            }
            else{
                result[i] = prefix[queries[i][1]]^ prefix[queries[i][0]-1];
            }
        }
        return result;
    }
}