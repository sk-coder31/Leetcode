class Solution {
    int[] drow = new int[]{1, 0};
    int[] dcol = new int[]{0, 1};
    Map<String, Boolean> memo = new HashMap<>();
    
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return dp(0, 0, 0, n, m, grid);
    }
    
    public boolean dp(int row, int col, int open, int n, int m, char[][] grid) {
        
        if (grid[row][col] == '(') {
            open++;
        } else {
            open--;
        }
        
        if (open < 0) return false;
        
        if (row == n - 1 && col == m - 1) {
            return open == 0;
        }
        
        String key = row + "," + col + "," + open;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        boolean ans = false;
        
        for (int i = 0; i < 2; i++) {
            int newRow = row + drow[i];
            int newCol = col + dcol[i];
            
            if (newRow < n && newCol < m) {
                ans = ans || dp(newRow, newCol, open, n, m, grid);
            }
        }
        
        memo.put(key, ans);
        return ans;
    }
}