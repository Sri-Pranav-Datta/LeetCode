class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i  < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // BFS toposort or Kahn algo
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int it : graph.get(i)) {
                indegree[it]++;
            }
        }
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            for(int it : graph.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        return (count == numCourses);
    }
}