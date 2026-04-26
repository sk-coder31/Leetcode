class Solution {
    int[] drow = new int[]{-1, 1, 0, 0};
    int[] dcol = new int[]{0, 0, -1, 1};
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[][] visited) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + drow[i];
            int nc = c + dcol[i];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                if (grid[nr][nc] == grid[r][c]) {
                    if (visited[nr][nc]) {
                        if (nr != pr || nc != pc) {
                            return true;
                        }
                    } else {
                        if (dfs(nr, nc, r, c, grid, visited)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}