class Disjoint {
    int[] parent;
    int[] rank;

    public Disjoint(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
        Arrays.fill(rank, 0);
    }

    public int findparent(int node) {
        if (node != parent[node]) {
            parent[node] = findparent(parent[node]);
        }
        return parent[node];
    }

    public void union(int node1, int node2) {
        int parent_node1 = findparent(parent[node1]);
        int parent_node2 = findparent(parent[node2]);

        if (parent_node1 == parent_node2) {
            return;
        }

        if (rank[parent_node1] < rank[parent_node2]) {
            parent[parent_node1] = parent_node2;
        } else if (rank[parent_node1] > rank[parent_node2]) {
            parent[parent_node2] = parent_node1;
        } else {
            parent[parent_node2] = parent_node1;
            rank[parent_node1]++;
        }
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Disjoint alice = new Disjoint(n + 1);
        Disjoint bob = new Disjoint(n + 1);

        Arrays.sort(edges, (a, b) -> {
            return b[0] - a[0];
        });
        int count = 0;
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            int parent_u_alice = alice.findparent(u);
            int parent_v_alice = alice.findparent(v);

            int parent_u_bob = bob.findparent(u);
            int parent_v_bob = bob.findparent(v);

            if (type == 3) {
                if (parent_u_alice == parent_v_alice && parent_u_bob == parent_v_bob) {
                    count++; 
                } else {
                    alice.union(u, v);
                    bob.union(u, v);
                }
            } else if (type == 1) {
                if (parent_u_alice == parent_v_alice) {
                    count++;
                } else {
                    alice.union(u, v);
                }
            } else {
                if (parent_u_bob == parent_v_bob) {
                    count++;
                } else {
                    bob.union(u, v);
                }
            }
        }
        int aliceRoots = 0;
        int bobRoots = 0;

        for (int i = 1; i <= n; i++) {
            if (alice.findparent(i) == i) aliceRoots++;
            if (bob.findparent(i) == i) bobRoots++;
        }

        if (aliceRoots != 1 || bobRoots != 1) return -1;

        return count;
    }
}