class Solution {
    int[][][] dirs = {
        {},
        {{0,-1},{0,1}},        
        {{-1,0},{1,0}},        
        {{0,-1},{1,0}},        
        {{0,1},{1,0}},         
        {{0,-1},{-1,0}},       
        {{0,1},{-1,0}}         
    };

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.add(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            if(r == n-1 && c == m-1) return true;

            int type = grid[r][c];

            for(int[] d : dirs[type]){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) continue;

                int nextType = grid[nr][nc];
                for(int[] back : dirs[nextType]){
                    if(nr + back[0] == r && nc + back[1] == c){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                        break;
                    }
                }
            }
        }
        return false;
    }
}