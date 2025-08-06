class Solution {
    int[] count;
    int[] result;
    int N;
    public int dfs1(Map<Integer, List<Integer>> adj, int curr_node, int prev_node, int curr_depth) {
        int total_node = 1;
        result[0] += curr_depth;

        for (int child : adj.get(curr_node)) {
            if (child == prev_node) continue;
            total_node += dfs1(adj, child, curr_node, curr_depth + 1);
        }

        count[curr_node] = total_node;
        return total_node;
    }

    public void dfs2(Map<Integer, List<Integer>> adj, int parent_node, int prev_node) {
        for (int child : adj.get(parent_node)) {
            if (child == prev_node) continue;

            result[child] = result[parent_node] - count[child] + (N - count[child]);
            dfs2(adj, child, parent_node);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.N = n;
        count = new int[n];
        result = new int[n];

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs1(adj, 0, -1, 0);
        dfs2(adj, 0, -1);

        return result;
    }
}
