class Solution {
    public int minTime(int n, int[][] edges) {
        if(edges.length==0 && n==1)return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] adj_nodes : edges) {
            int u = adj_nodes[0];
            int v = adj_nodes[1];
            int start = adj_nodes[2];
            int end = adj_nodes[3];

            adj.get(u).add(new int[] { v, start, end });
        }
        pq.add(new int[] { 0, 0 });//time , node

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int curr_time = arr[0];
            int curr_node = arr[1];
            for (int[] adj_nodes : adj.get(curr_node)) {
                int adj_node = adj_nodes[0];
                int start_time = adj_nodes[1];
                int end_time = adj_nodes[2];

                if (curr_time >= start_time && curr_time <= end_time) {
                    if (curr_time + 1 < dist[adj_node]) {
                        dist[adj_node] = curr_time + 1;
                        pq.add(new int[] { curr_time + 1, adj_node });
                    }
                } else if (curr_time > end_time) {
                    continue;
                } else if (curr_time < start_time) {
                    if (start_time + 1 < dist[adj_node]) {
                        dist[adj_node] = start_time + 1;
                        pq.add(new int[] { start_time + 1, adj_node });
                    }
                }

            }
        }
        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}