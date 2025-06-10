class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
 
class Solution {
    
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        for(int i = 0; i <n; i++) {
            for(int j = 0; j <m; j++) {
                if(grid[i][j]==2) {
                    //add initial rotten oranges
                    q.offer(new Pair(i,j));
                }
                if(grid[i][j]==1) {
                    fresh++;
                }
            }
        }
        int time = 0;
        Pair[] directions = {new Pair(-1,0), new Pair(1,0), new Pair(0, -1), new Pair(0, 1)};
        while(!q.isEmpty()) {
            if(fresh == 0) break;
            int s = q.size();
            time++;
            for(int i = 0; i < s; i++) {
                Pair temp = q.poll();
                int currow = temp.r;
                int curcol = temp.c;
                for(Pair d : directions) {
                    int nrow = currow + d.r;
                    int ncol = curcol + d.c;
                    if(nrow >=0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        fresh--;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }
            
        }
        return (fresh == 0) ? time : -1;
    }
}