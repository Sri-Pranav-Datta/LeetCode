class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        //create graph
        for(int i = 0; i  < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        // BFS toposort or Kahn algo
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        int[] topo = new int[numCourses];
        int count = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            topo[count++] = node;
            for(int it : graph.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        int[] nores = {};
        return (count == numCourses) ? topo : nores;
    }
}