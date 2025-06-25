class Pair {
    int node;
    long dist;

    public Pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1];
            long wt = road[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        long[] time = new long[n];
        int[] paths = new int[n];
        Arrays.fill(time, Long.MAX_VALUE);

        time[0] = 0;
        paths[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.offer(new Pair(0, 0));

        int mod = 1_000_000_007;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            long curTime = curr.dist;

            if (curTime > time[node]) continue;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                long wt = neighbor.dist;

                if (curTime + wt < time[adjNode]) {
                    time[adjNode] = curTime + wt;
                    paths[adjNode] = paths[node];
                    pq.offer(new Pair(adjNode, time[adjNode]));
                } else if (curTime + wt == time[adjNode]) {
                    paths[adjNode] = (paths[adjNode] + paths[node]) % mod;
                }
            }
        }

        return paths[n - 1];
    }
}
