class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        List<List<Integer>> adj1 = new ArrayList<>();
        for(int i = 0; i <= k; i++){
            adj1.add(new ArrayList<>());
        }
        for(int[] arr : rowConditions){
            adj1.get(arr[0]).add(arr[1]);
        }

        List<List<Integer>> adj2 = new ArrayList<>();
        for(int i = 0; i <= k; i++){
            adj2.add(new ArrayList<>());
        }
        for(int[] arr : colConditions){
            adj2.get(arr[0]).add(arr[1]);
        }

        int[] res1 = toposort(adj1, k);
        if(res1.length == 0) return new int[][]{};
        int[] res2 = toposort(adj2, k);
        if(res2.length == 0) return new int[][]{};

        
        Map<Integer,Integer> colPos = new HashMap<>();
        for(int j = 0; j < k; j++){
            colPos.put(res2[j], j);
        }

        
        int[][] grid = new int[k][k];
        for(int i = 0; i < k; i++){
            int val = res1[i];
            int j = colPos.get(val);
            grid[i][j] = val;
        }
        return grid;
    }

    public int[] toposort(List<List<Integer>> adj, int size){
        int[] indegree = new int[size+1];
        for(int i = 1; i <= size; i++){
            for(int adjnode : adj.get(i)){
                indegree[adjnode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= size; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int[] result = new int[size];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            result[idx++] = node;
            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }

        if(idx != size){
            return new int[]{}; 
        }
        return result;
    }
}
