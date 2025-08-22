class Solution {
    public int minimumArea(int[][] grid) {
        int min_row = Integer.MAX_VALUE;
        int min_col = Integer.MAX_VALUE;
        int max_row = Integer.MIN_VALUE;
        int max_col = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max_col = Math.max(max_col, j);
                    min_col = Math.min(min_col, j);
                    min_row = Math.min(i, min_row);
                    max_row = Math.max(i, max_row);
                }
            }
        }
        int l = max_col - min_col + 1;
        int b = max_row - min_row + 1;
        return l * b;
    }
}