class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList,(a,b)->{
            return a[2]-b[2];
        });
        int[][] queriesindex = new int[queries.length][4];
        for(int i = 0 ; i < queries.length ; i++){
            queriesindex[i][0] = queries[i][0];
            queriesindex[i][1] = queries[i][1];
            queriesindex[i][2] = queries[i][2];
            queriesindex[i][3] = i;
        }
        Arrays.sort(queriesindex,(a,b)->{
            return a[2]-b[2];
        });
        int j = 0;
        boolean[] ans = new boolean[queries.length];
        Disjoint dis = new Disjoint(n+1);
        for(int i = 0; i < queries.length ; i++){
            int u = queriesindex[i][0];
            int v = queriesindex[i][1];
            int wt = queriesindex[i][2];
            int idx = queriesindex[i][3];
            while(j < edgeList.length && edgeList[j][2] < wt){
                dis.union(edgeList[j][0],edgeList[j][1]);
                j++;
            }
            if(dis.findparent(u)==dis.findparent(v)){
                ans[idx] = true;
            }else{
                ans[idx] = false;
            }
        }
        return ans;

    }
}
class Disjoint {
    int[] parent;
    int[] rank;

    public Disjoint(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0; 
        }
    }

    public int findparent(int node) {
       
        if (parent[node] != node) {
            parent[node] = findparent(parent[node]); 
        }
        return parent[node];
    }

    public void union(int node1, int node2) {
        int parent_node1 = findparent(node1);
        int parent_node2 = findparent(node2);

        if (parent_node1 == parent_node2) return;

        
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
