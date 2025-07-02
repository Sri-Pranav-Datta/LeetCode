class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for(int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUltPar (int node) {
        if(parent.get(node) == node) return node;
        int p = parent.get(node);
        int ulp = findUltPar(p);
        parent.set(node, ulp);
        return ulp;
    }
    public void unionBySize (int u, int v) {
        int pu = findUltPar(u);
        int pv = findUltPar(v);
        if(pu == pv) return;
        int su = size.get(pu);
        int sv = size.get(pv);
        if(su < sv) {
            parent.set(pu, pv);
            size.set(pv, su + sv);
        }
        else {
            parent.set(pv, pu);
            size.set(pu, su + sv);
        }
        
    }
}
class Solution {
    private boolean isValid(int r, int c, int n) {
        return r>=0 && c>=0 && r<n && c<n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                for(int l = 0; l < 4; l++) {
                    int newr = i + dr[l];
                    int newc = j + dc[l];
                    if(isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeno = i * n + j;
                        int adjno = newr * n + newc;
                        ds.unionBySize(nodeno, adjno);
                    }
                }
            }
        }
        int maxi = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) continue;
                HashSet<Integer> parents = new HashSet<>();
                for(int l = 0; l < 4; l++) {
                    int newr = i + dr[l];
                    int newc = j + dc[l];
                    if(isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        //int nodeno = i * n + j;
                        int adjno = newr * n + newc;
                        int pnode = ds.findUltPar(adjno);
                        parents.add(pnode);
                    }
                }
                int sz = 1;
                for(Integer parent : parents) {
                    sz += ds.size.get(parent);
                }
                maxi = Math.max(maxi , sz);
            }
        }
        // if all are 1 then we have to add the size of that
        for(int i = 0; i < n; i++) {
            maxi = Math.max(maxi , ds.size.get(ds.findUltPar(i)));
        }
        return maxi;
    }
}