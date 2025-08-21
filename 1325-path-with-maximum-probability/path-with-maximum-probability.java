class Pair{
    int node;
    double wt;
    Pair(int node,double wt){
        this.node = node;
        this.wt = wt;
    }
    
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>>adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int i = 0;
        for(int [] arr : edges){
            int u = arr[0];
            int v = arr[1];
            double wt = succProb[i];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
            i++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.wt, a.wt));
        double[] dist = new double[n];
        Arrays.fill(dist,0.0);
        dist[start_node] = 1.0;
        pq.add(new Pair(start_node,1.0));        
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int u = node.node;
            double curr_wt = node.wt;
            if(u == end_node){
                return curr_wt;
            }
            for(Pair edge : adj.get(u)){
                int adj_node = edge.node;
                double next_wt = edge.wt;
                if(curr_wt * next_wt>dist[adj_node]){
                    dist[adj_node] = curr_wt * next_wt;
                    pq.add(new Pair(adj_node,curr_wt*next_wt));
                }
            }
        }
        return dist[end_node];


    }
}