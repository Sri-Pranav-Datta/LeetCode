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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)) {
                    map.put(mail, i);
                }
                else {
                    ds.unionRank(i, map.get(mail));
                    map.put(mail, i);
                }
            }
        }
        List<String>[] mails = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            mails[i] = new ArrayList<>();
        }
        for(Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int p = ds.findUPar(it.getValue());
            mails[p].add(mail);
        }
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(mails[i].size() == 0) continue;
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // adding the name
            Collections.sort(mails[i]);
            for(String mail : mails[i]) {
                temp.add(mail);
            }
            res.add(temp);
        }
        return res;
    }
}