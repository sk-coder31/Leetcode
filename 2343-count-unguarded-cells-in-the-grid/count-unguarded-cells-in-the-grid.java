class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] row : guards) {
            int r = row[0];
            int c = row[1];
            grid[r][c] = 1;
        }
        for (int[] row : walls) {
            int r = row[0];
            int c = row[1];
            grid[r][c] = -1;
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = i - 1; k >= 0 && grid[k][j] != -1 && grid[k][j] != 1; k--)
                        grid[k][j] = 2; 
                    for (int k = i + 1; k < m && grid[k][j] != -1 && grid[k][j] != 1; k++)
                        grid[k][j] = 2; 
                    for (int k = j - 1; k >= 0 && grid[i][k] != -1 && grid[i][k] != 1; k--)
                        grid[i][k] = 2; 
                    for (int k = j + 1; k < n && grid[i][k] != -1 && grid[i][k] != 1; k++)
                        grid[i][k] = 2; 

                }
            }
        }
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j]==0)count++;
            }
        }
        return count;
    }
}