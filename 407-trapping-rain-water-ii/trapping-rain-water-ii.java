class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int[] drow = new int[]{-1,1,0,0};
        int[] dcol = new int[]{0,0,-1,1};
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < m ; i++){
            pq.add(new int[]{heightMap[0][i],0,i});
            pq.add(new int[]{heightMap[n-1][i],n-1,i});
            visited[0][i] = true;
            visited[n-1][i] = true;
        }
        for(int i = 0 ; i < n ; i++){
            pq.add(new int[]{heightMap[i][0],i,0});
            pq.add(new int[]{heightMap[i][m-1],i,m-1});
            visited[i][0] = true;
            visited[i][m-1] = true;
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int[] state = pq.poll();
            int ht = state[0];
            int i = state[1];
            int j = state[2];

            for(int k = 0 ; k < 4 ; k++){
                int delrow = i + drow[k];
                int delcol = j + dcol[k];
                if(delrow >= 0 && delcol >=0 && delrow < n && delcol < m && !visited[delrow][delcol]){
                    int diff = Math.max(ht-heightMap[delrow][delcol],0);
                    ans+=diff;
                    int max = Math.max(heightMap[delrow][delcol],ht);
                    pq.add(new int[]{max,delrow,delcol});
                    visited[delrow][delcol] = true;
                }
            }
        }
        return ans;
    }
}