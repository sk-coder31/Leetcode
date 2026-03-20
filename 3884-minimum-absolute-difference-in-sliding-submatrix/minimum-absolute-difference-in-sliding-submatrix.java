class Solution {
    int n, m;
    public int[][] minAbsDiff(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        int[][] ans = new int[n-k+1][m-k+1];
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                ans[i][j] = helper(i, j, k, grid);
            }
        }
        return ans;
    }

    public int helper(int i, int j, int k, int[][] grid) {
        List<Integer> ls = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

        for (int x = i; x < i + k; x++) {
            for (int y = j; y < j + k; y++) {
                if (!hs.contains(grid[x][y])) {
                    ls.add(grid[x][y]);
                    hs.add(grid[x][y]);
                }
            }
        }
        if (ls.size() <= 1) return 0;

        Collections.sort(ls);

        int min = Integer.MAX_VALUE;

        for (int t = 1; t < ls.size(); t++) {
            min = Math.min(min, Math.abs(ls.get(t) - ls.get(t - 1)));
        }

        return min;
    }
}