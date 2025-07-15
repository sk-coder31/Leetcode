class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Disjoint dsu = new Disjoint(c + 1);
        for (int[] edge : connections) {
            dsu.union(edge[0], edge[1]);
        }
        HashMap<Integer, TreeSet<Integer>> componentNodes = new HashMap<>();
        for (int i = 0; i <= c; i++) {
            int root = dsu.findparent(i);
            componentNodes.putIfAbsent(root, new TreeSet<>());
            componentNodes.get(root).add(i);
        }
        
        int[] result = new int[queries.length];
        int resultIndex = 0;
        
        for (int[] query : queries) {
            int type = query[0];
            int node = query[1];
            int root = dsu.findparent(node);
            TreeSet<Integer> availableNodes = componentNodes.get(root);
            
            if (type == 1) {
                if (availableNodes == null || availableNodes.isEmpty()) {
                    result[resultIndex++] = -1;
                } else {
                    if (availableNodes.contains(node)) {
                        result[resultIndex++] = node;
                    } else {
                        result[resultIndex++] = availableNodes.first();
                    }
                }
            } else {
                if (availableNodes != null) {
                    availableNodes.remove(node); 
                }
            }
        }

        return Arrays.copyOf(result, resultIndex);
    }
}

class Disjoint {
    int[] parent;
    int[] rank;
    
    Disjoint(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int findparent(int node) {
        if (node != parent[node]) {
            parent[node] = findparent(parent[node]);  
        }
        return parent[node];
    }
    
    public void union(int node1, int node2) {
        int p1 = findparent(node1);
        int p2 = findparent(node2);
        
        if (p1 == p2) return;
        

        if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
            rank[p2]++;
        }
    }
}