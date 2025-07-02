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
    public int removeStones(int[][] stones) {
        int rows = -1;
        int cols = -1;
        for(int i = 0; i < stones.length; i++) {
            rows = Math.max(rows,stones[i][0]);
            cols = Math.max(cols, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(rows + cols +2);
        HashSet<Integer> stoneNodes = new HashSet<>();
        for(int[] stone : stones) {
            ds.unionBySize(stone[0], stone[1] + rows +1);
            stoneNodes.add(stone[0]);
            stoneNodes.add(stone[1] + rows + 1);
        }
        int count = 0;
        for(Integer stone : stoneNodes) {
            if(ds.findUltPar(stone) == stone) {
                count++;
            }
        }
        return stones.length - count;
    }
}