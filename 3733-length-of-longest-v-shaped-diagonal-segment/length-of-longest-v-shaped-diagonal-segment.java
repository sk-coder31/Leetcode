class Solution {
    int[] drow = { 1, -1, 1, -1 };
    int[] dcol = { 1, -1, -1, 1 };
    int[] clockwise = { 2, 3, 1, 0 };
    Integer[][][][]memo;

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        memo = new Integer[n][m][4][2]; 
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        max = Math.max(max, 1 + dp(i, j, dir, 1, 1, grid));
                    }
                }
            }
        }
        return max;
    }

    public int dp(int r, int c, int dir, int turn, int parity, int[][] grid) {
        if (memo[r][c][dir][turn] != null) {
            return memo[r][c][dir][turn];
        }

        int nextVal = (parity == 1 ? 2 : 0);
        int best = 0;

        int nr = r + drow[dir], nc = c + dcol[dir];
        if (ok(nr, nc, grid.length, grid[0].length) && grid[nr][nc] == nextVal) {
            best = Math.max(best, 1 + dp(nr, nc, dir, turn, 1 - parity, grid));
        }

        if (turn == 1) {
            int ndir = clockwise[dir];
            int tr = r + drow[ndir], tc = c + dcol[ndir];
            if (ok(tr, tc, grid.length, grid[0].length) && grid[tr][tc] == nextVal) {
                best = Math.max(best, 1 + dp(tr, tc, ndir, 0, 1 - parity, grid));
            }
        }

        return memo[r][c][dir][turn] = best;
    }

    public boolean ok(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
