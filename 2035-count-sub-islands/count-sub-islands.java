class Solution {
    int[] drow = new int[]{-1,1,0,0};
    int[] dcol = new int[]{0,0,-1,1};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid2[i][j] == 1 && !visited[i][j]){
                    if(bfs(grid1,grid2,i,j,visited)){
                        count++;
                    } 
                }
            }
        }
        return count;
    }
    public boolean bfs(int[][] grid1,int[][] grid2,int r,int c,boolean[][] visited){
        int n = grid1.length;
        int m = grid1[0].length;
        boolean isSub = true;
        Queue<int[]>q = new LinkedList<>(); 
        q.add(new int[]{r,c});
        visited[r][c] = true;
        while(!q.isEmpty()){
            int[] curr_node = q.poll();
            int row = curr_node[0];
            int col = curr_node[1];

            if(grid1[row][col]==0){
                isSub = false;
            }
            for(int i = 0 ; i < 4 ; i++){
                int delrow = drow[i] + curr_node[0];
                int delcol = dcol[i] + curr_node[1];
                if(delrow>=0 && delrow<n && delcol<m && delcol>=0 && grid2[delrow][delcol]==1 && !visited[delrow][delcol]){
                    q.add(new int[]{delrow,delcol});
                    visited[delrow][delcol] = true;
                }
            }
        }
        return isSub;
        
    }
}