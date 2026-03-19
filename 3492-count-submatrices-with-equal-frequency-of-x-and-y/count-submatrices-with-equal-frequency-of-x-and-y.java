class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') {
                    matrix[i][j] = 1;
                } else if (grid[i][j] == 'Y') {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        int[][] prefix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = matrix[i][j];

                if (i > 0)
                    val += prefix[i - 1][j];
                if (j > 0)
                    val += prefix[i][j - 1];
                if (i > 0 && j > 0)
                    val -= prefix[i - 1][j - 1];

                prefix[i][j] = val;
            }
        }
        int[][] xPrefix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = (grid[i][j] == 'X') ? 1 : 0;

                if (i > 0)
                    val += xPrefix[i - 1][j];
                if (j > 0)
                    val += xPrefix[i][j - 1];
                if (i > 0 && j > 0)
                    val -= xPrefix[i - 1][j - 1];

                xPrefix[i][j] = val;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (prefix[i][j] == 0 && xPrefix[i][j]>=1) {
                    count++;
                }
            }
        }
        return count;
    }
}