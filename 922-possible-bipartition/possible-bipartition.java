class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0 ; i < n+1 ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < dislikes.length ; i++){
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] color = new int[n+1];
        int count = 0;
        Arrays.fill(color,-1);
        for(int i = 1 ; i <= n ; i++){
            if (color[i] != -1) continue;
            int node = i;
            Queue<Integer>q = new LinkedList<>();
            q.add(node);
            color[node] = 1;
            count++;
            while(!q.isEmpty()){
                node = q.poll();
                for(int adj_node:adj.get(node)){
                    if(color[adj_node]==-1){
                        color[adj_node] = Math.abs(color[node] - 1);
                        q.add(adj_node);
                    }else{
                        if(color[node]==color[adj_node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}