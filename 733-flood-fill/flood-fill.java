class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q = new LinkedList<Pair>();
        int org = image[sr][sc];
        if(org == color) return image;
        int n = image.length;
        int m = image[0].length;
        Pair[] directions = {new Pair(-1,0), new Pair(1,0), new Pair(0, -1), new Pair(0, 1)};
        q.add(new Pair(sr, sc));
        while(!q.isEmpty()) {
            Pair temp = q.poll();
            int cr = temp.r;
            int cc = temp.c;
            image[cr][cc] = color;
            for(Pair d : directions) {
                int delr = d.r;
                int delc = d.c;
                if(cr+delr >= 0 && cr+ delr < n && cc + delc >= 0 && cc + delc < m && image[cr+ delr][cc+delc] == org) {
                    q.offer(new Pair(cr+delr,cc+delc));
                }
            }
        }
        return image;
    }
}