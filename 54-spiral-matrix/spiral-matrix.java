class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top =0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(top<=bottom && left<=right){
            //top row iteration

            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            
            //right column iteration

            for(int i=top; i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                //bottom row iteration
                for(int i=right; i>=left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }          
            //left column iteration
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}