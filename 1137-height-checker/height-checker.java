class Solution {

    public int heightChecker(int[] heights) {
        int max = heights[0];
        int n = heights.length;
        // maximum of an array
        for (int i = 1; i < n; i++) {
            if (heights[i] > max) {
                max = heights[i];
            }
        }
        //count array
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[heights[i]]++;
        }
        int[] expected = new int[n];
        int index = 0;
        //sorted array
        for(int i=0; i< max+1; i++){
            while(count[i]> 0){
                expected[index] = i;
                index++;
                count[i]--;
            }
        }
        int result = 0;
        //check both arrays
        for(int i=0;i<n ;i++){
            if(expected[i] != heights[i]){
                result++;
            }
        }
        return result;
    }
}