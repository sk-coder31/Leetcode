class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        DSU dsu = new DSU(n);
        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = dsu.findparent(i);
            map.putIfAbsent(root, new HashMap<>());
            
            Map<Integer, Integer> freq = map.get(root);
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }
        int mismatch = 0;

        for (int i = 0; i < n; i++) {
            int root = dsu.findparent(i);
            Map<Integer, Integer> freq = map.get(root);

            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                mismatch++;
            }
        }

        return mismatch;
    }
}
class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int findparent(int node){
        if(parent[node]!=node){
            return parent[node] = findparent(parent[node]);
        }
        return parent[node];
    }
    public void union(int a,int b){
        if(a == b){
            return;
        }
        int root1 = findparent(a);
        int root2 = findparent(b);
        if(root1 == root2){
            return;
        }
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }
}