class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for(int i = 0; i< n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if(parent.get(node) == node) return node;
        int p = parent.get(node);
        int up = findUPar(p);
        parent.set(node, up);
        return up;
    }

    public void unionRank(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);
        int ru = rank.get(pu);
        int rv = rank.get(pv);
        if(ru < rv) {
            parent.set(pu, pv);
            return;
        }
        else if(rv < ru) {
            parent.set(pv, pu);
            return;
        }
        parent.set(pv, pu);
        rank.set(pu, ru+1);
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int extra = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUPar(u) == ds.findUPar(v)) extra++;
            else {
                ds.unionRank(u,v);
            }
        }
        int cc = 0;
        for(int i = 0; i < n; i++) {
            if(i == ds.parent.get(i)) cc++;
        }
        if(extra >= cc-1) return cc-1;
        return -1;
    }
}