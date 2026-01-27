class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>>adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] nn : edges){
            int u = nn[0];
            int v = nn[1];
            int wt = nn[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,2*wt});
        }

        PriorityQueue<int[]>pq = new PriorityQueue<>((int[] a,int[] b)->{
            return a[1]-b[1];
        });
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];

            if(cost>dist[node]){
                continue;
            }
            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int wt = nei[1];

                if (dist[next] > cost + wt) {
                    dist[next] = cost + wt;
                    pq.add(new int[]{next, dist[next]});
                }
            }   
        }
        return dist[n-1]==Integer.MAX_VALUE ? -1 : dist[n-1];
    }
}