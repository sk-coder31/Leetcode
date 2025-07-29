class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        Integer[][] memo = new Integer[n][m];
        return dp(0, 0, dungeon, memo);
    }

    public int dp(int r, int c, int[][] dungeon, Integer[][] memo) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        if (r >= n || c >= m) return Integer.MAX_VALUE;

        if (memo[r][c] != null) return memo[r][c];

        if (r == n - 1 && c == m - 1) {
            return Math.max(1, 1 - dungeon[r][c]);
        }

        int right = dp(r, c + 1, dungeon, memo);
        int down = dp(r + 1, c, dungeon, memo);

        int need = Math.min(right, down) - dungeon[r][c];

        memo[r][c] = Math.max(1, need);
        return memo[r][c];
    }
}
