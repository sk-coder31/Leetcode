class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        HashSet<Integer> visited_routes = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                adj.putIfAbsent(routes[i][j], new ArrayList<>());
                adj.get(routes[i][j]).add(i);
            }
        }

        if (!adj.containsKey(source)) return -1;
        
        for (int route : adj.get(source)) {
            visited_routes.add(route);
            q.add(route);
        }
        
        int busCount = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int route = q.poll();
                
                for (int stop : routes[route]) {
                    if (stop == target) return busCount;
                    
                    for (int next : adj.getOrDefault(stop, Collections.emptyList())) {
                        if (!visited_routes.contains(next)) {
                            q.add(next);
                            visited_routes.add(next);
                        }
                    }
                }
            }
            busCount++;
        }
      
        
        return -1;
    }
}