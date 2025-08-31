class Solution {
    int[][][] memo;
    int mod = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        memo = new int[n][m][3];
        for (int[][] arr : memo) {
            for (int[] j : arr) {
                Arrays.fill(j, -1);
            }
        }
        int r = 0;
        int c = 0;
        return dp(r, c, 2 ,grid);
    }

    public int dp(int r, int c, int dir, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 0;
        }
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return 1;
        }

        if (memo[r][c][dir] != -1) {
            return memo[r][c][dir];
        }

        int count = 0;
        if(dir==2){
            count = (dp(r+1,c,0,grid) + dp(r,c+1,1,grid))%mod;
        }
        if (grid[r][c] == 0) {
            count =  (dp(r + 1, c, 0, grid) + dp(r,c+1,1,grid))%mod;
        }
        if (grid[r][c] == 1) {
            if (dir == 1) {
                count += dp(r + 1, c, 0, grid) % mod;
            } else {
                count += dp(r, c + 1, 1, grid) % mod;
            }
        }
        return memo[r][c][dir] = count%mod;
    }
}