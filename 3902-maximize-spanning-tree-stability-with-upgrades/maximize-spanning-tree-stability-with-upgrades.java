class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int m = edge[3];

            if (m == 1) {
                if (dsu.find(u) == dsu.find(v)) {
                    return -1;
                }
                dsu.union(u, v);
            }
        }
        int low = 1;
        int high = (int) 2e5;
        int res = -1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (helper(n, edges, k, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public boolean helper(int n, int[][] edges, int k, int mid) {
        DSU dsu = new DSU(n);
        int[][] sorted = edges.clone();
        Arrays.sort(sorted, (a, b) -> b[3] - a[3]);
        List<int[]> up = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int u = sorted[i][0];
            int v = sorted[i][1];
            int s = sorted[i][2];
            int flag = sorted[i][3];
            if (dsu.find(u) == dsu.find(v)) {
                continue; 
            }
            if (flag == 1) {
                if (s >= mid) {
                    dsu.union(u, v);
                } else {
                    return false;
                }
            } else if (flag == 0) {
                if (s >= mid) {
                    dsu.union(u, v);
                    continue;
                } else if (2 * s >= mid ) {
                    up.add(sorted[i]);
                }
            }
        }
        for (int[] arr : up) {
            int u = arr[0];
            int v = arr[1];
            if (dsu.find(u) != dsu.find(v)) {
                if (k <= 0) {
                    return false;
                }
                dsu.union(u, v);
                k--;
            }
        }
        int check = dsu.find(0);
        for (int i = 1; i < n; i++) {
            if (check != dsu.find(i)) {
                return false;
            }
        }
        return true;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public boolean union(int u, int v) {
        int p_u = find(u);
        int p_v = find(v);

        if (p_u == p_v) {
            return false;
        }
        if (rank[p_u] < rank[p_v]) {
            parent[p_u] = p_v;
        } else if (rank[p_u] > rank[p_v]) {
            parent[p_v] = p_u;
        } else {
            parent[p_v] = p_u;
            rank[p_u]++;
        }
        return true;
    }
}