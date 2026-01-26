class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        
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

    public List<Integer> getDistance(int n, int start, List<List<Integer>> adj) {

        List<Integer> dist = new ArrayList<>(Collections.nCopies(n, -1));

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist.set(start, 0);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : adj.get(node)) {
                if (dist.get(nei) == -1) {
                    dist.set(nei, dist.get(node) + 1);
                    q.add(nei);
                }
            }
        }
        return dist;
    }

}