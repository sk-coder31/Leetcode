class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        for (int[] i : edges) {
            System.out.println(Arrays.toString(i));
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] nodes : edges) {
            int u = nodes[0];
            int v = nodes[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<Integer> dist_x = getDistance(n, x, adj);
        List<Integer> dist_y = getDistance(n, y, adj);
        List<Integer> dist_z = getDistance(n, z, adj);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int node = i;
            if (giveDist(node, dist_x, dist_y, dist_z)) {
                count++;
            }
        }
        return count;
    }

    public boolean giveDist(int node,
            List<Integer> dist_x,
            List<Integer> dist_y,
            List<Integer> dist_z) {

        int[] arr = new int[] {
                dist_x.get(node),
                dist_y.get(node),
                dist_z.get(node)
        };

        Arrays.sort(arr);

        return arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2];
    }

    public List<Integer> getDistance(int n, int x, List<List<Integer>> adj) {
        List<Integer> dist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dist.add(0);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, 0 });
        boolean[] visited = new boolean[n];
        visited[x] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                for (int adj_nodes : adj.get(node[0])) {
                    if (!visited[adj_nodes]) {
                        dist.set(adj_nodes, node[1] + 1);
                        q.add(new int[]{adj_nodes,node[1]+1});
                        visited[adj_nodes] = true;
                    }
                }
            }
        }
        return dist;
    }
}