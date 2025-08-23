class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(Arrays.stream(stones).boxed().toList());
        while(!pq.isEmpty()) {
            int a = pq.poll();
            if(pq.isEmpty()) {
                return a;
            }
            int b = pq.poll();
            if(a!=b) {
                pq.offer(Math.abs(a-b));
            }
         }
         return 0;
    }
}