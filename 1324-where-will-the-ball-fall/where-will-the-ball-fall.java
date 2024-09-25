class Solution {
    public int[] findBall(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] result = new int[c];
        Arrays.fill(result,-1);
        for(int i=0;i<c;i++){// for every ball
            int currCol = i;
            for(int j = 0; j<r;j++){// ball passing through each row
                int nextCol = currCol + grid[j][currCol];
                if(nextCol<0 || nextCol>c-1) break;
                if(grid[j][currCol]!= grid[j][nextCol]) break;
                currCol = nextCol;
                if(j==r-1){
                    result[i]=currCol;
                }
            }
        }
        return result;
    }
}