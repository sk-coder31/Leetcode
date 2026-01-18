class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] rowsum = row_sum(grid);
        int[][] colsum = col_sum(grid);
        for (int size = Math.min(n, m); size >= 1; size--) {
            for (int i = 0; i + size - 1 < n; i++) {
                for (int j = 0; j + size - 1 < m; j++) {
                    int target = rowsum[i][j + size - 1] - (j > 0 ? rowsum[i][j - 1] : 0);
                    boolean flag = true;
                    for (int r = i + 1; r < i + size; r++) {
                        int row = rowsum[r][j + size - 1] - (j > 0 ? rowsum[r][j - 1] : 0);
                        if (row != target) {
                            flag = false;
                            break;
                        }
                    }
                    for (int c = j + 1; c < j + size; c++) {
                        int col = colsum[i + size - 1][c] - (i > 0 ? colsum[i - 1][c] : 0);
                        if (col != target) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag)
                        continue;
                    int diag = 0;
                    int antiDiag = 0;
                    for (int k = 0; k < size; ++k) {
                        diag += grid[i + k][j + k];
                        antiDiag += grid[i + k][j + size - 1 - k];
                    }

                    if (diag == target && antiDiag == target) {
                        return size;
                    }
                }
            }
        }
        return 0;
    }

    public int[][] row_sum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            arr[i][0] = grid[i][0];
            for (int j = 1; j < m; j++) {
                arr[i][j] = arr[i][j - 1] + grid[i][j];
            }
        }
        return arr;
    }

    public int[][] col_sum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = new int[n][m];

        for (int j = 0; j < m; j++) {
            arr[0][j] = grid[0][j];
            for (int i = 1; i < n; i++) {
                arr[i][j] = arr[i - 1][j] + grid[i][j];
            }
        }
        return arr;
    }

}
