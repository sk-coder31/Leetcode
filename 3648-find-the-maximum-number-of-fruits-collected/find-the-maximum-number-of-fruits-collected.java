class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private int n;
    private int[][] fruits;
    private int[][] memo;
    private List<int[]> dirs;
    private int dfs(int row, int col, int moves) {
        if (row == n - 1 && col == n - 1) {
            return (moves == 0) ? 0 : INF;
        }
        if (moves == 0 || row == col) {
            return INF;
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        long best = -1;
        for (int[] d : dirs) {
            int nr = row + d[0], nc = col + d[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                int val = dfs(nr, nc, moves - 1);
                if (val != INF) {
                    best = Math.max(best, (long) val);
                }
            }
        }
        int result = (best < 0 ? INF : fruits[row][col] + (int) best);
        memo[row][col] = result;
        return result;
    }

    public int maxCollectedFruits(int[][] fruits) {
        this.n = fruits.length;
        this.fruits = fruits;

        long first = 0;
        for (int i = 0; i < n; i++) {
            first += fruits[i][i];
        }
        dirs = Arrays.asList(
            new int[]{1, -1},
            new int[]{1, 0},
            new int[]{1, 1}
        );
        memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        int second = dfs(0, n - 1, n - 1);

       
        dirs = Arrays.asList(
            new int[]{-1, 1},
            new int[]{0, 1},
            new int[]{1, 1}
        );
        for (int[] row : memo) Arrays.fill(row, -1);
        int third = dfs(n - 1, 0, n - 1);

        return (int) (first + second + third);
    }
}
