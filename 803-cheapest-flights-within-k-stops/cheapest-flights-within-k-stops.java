class Pair {
    int node;
    int price;

    public Pair(int node, int price) {
        this.node = node;
        this.price = price;
    }
}
class Tuple {
    int stops;
    int node;
    int distance;

    public Tuple(int stops,int node, int distance) {
    this.stops =  stops;
    this.node =  node;
    this.distance = distance; 
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        int ne = flights.length;
        for(int i = 0; i < ne; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) {
            dist[i] = (int)1e9;
        }
        dist[src] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.stops - b.stops);
        pq.add(new Tuple(0, src, 0));
        while(!pq.isEmpty()) {
            Tuple temp = pq.poll();
            int stops = temp.stops;
            int node = temp.node;
            int distance = temp.distance;
            if(stops > k) break;
            for(Pair neigh : adj.get(node)) {
                if(distance + neigh.price < dist[neigh.node]) {
                    dist[neigh.node] = distance + neigh.price;
                    pq.add(new Tuple(stops+1, neigh.node, distance + neigh.price));
                }
            }
        }
        if(dist[dst] == 1e9) return -1;
        return dist[dst];
    }
}