class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, 2 * wt}); 
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] mincost = new int[n];
        Arrays.fill(mincost, Integer.MAX_VALUE);
        mincost[0] = 0;
        pq.add(new int[]{0, 0});

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int curr_wt = node[0];
            int curr_node = node[1];

            if (visited[curr_node]) continue;
            visited[curr_node] = true;

            for (int[] adj_node : adj.get(curr_node)) {
                int neigh = adj_node[0];
                int weight = adj_node[1];

                int newdist = curr_wt + weight;
                if (newdist < mincost[neigh]) {
                    mincost[neigh] = newdist;
                    pq.add(new int[]{newdist, neigh});
                }
            }
        }

        return mincost[n - 1] == Integer.MAX_VALUE ? -1 : mincost[n - 1];
    }
}
