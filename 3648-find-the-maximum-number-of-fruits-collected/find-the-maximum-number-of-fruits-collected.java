class Solution {
    int[][] m2;
    public int maxCollectedFruits(int[][] f) {
        int n = f.length;
        
        int c1 = 0;
        for(int i = 0; i < n; i++){
            c1 += f[i][i];
        }
        
        m2 = new int[n][n];
        for(int[] row : m2) Arrays.fill(row, -1);
        int c2 = dp2(0, n-1, f, n-1, n);
        for(int[] row : m2) Arrays.fill(row, -1);
        int c3 = dp3(n-1, 0, f, n-1, n);
        
        return c1 + c2 + c3 - 2 * f[n-1][n-1];
    }
    
    public int dp2(int r, int c, int[][] f, int mv, int n){
        if(r == n-1 && c == n-1){
            return f[r][c];
        }
        
        if(r >= n || c < 0 || c >= n || mv <= 0){
            return Integer.MIN_VALUE;
        }
        
        if(r == c && !(r == n-1 && c == n-1)){
            return Integer.MIN_VALUE;
        }
        if(m2[r][c] != -1){
            return m2[r][c];
        }
        
        int max = Integer.MIN_VALUE;
        
        if(r + 1 < n && c - 1 >= 0){
            int res = dp2(r + 1, c - 1, f, mv - 1, n);
            if(res != Integer.MIN_VALUE){
                max = Math.max(max, res);
            }
        }
        
        if(r + 1 < n){
            int res = dp2(r + 1, c, f, mv - 1, n);
            if(res != Integer.MIN_VALUE){
                max = Math.max(max, res);
            }
        }
        
        if(r + 1 < n && c + 1 < n){
            int res = dp2(r + 1, c + 1, f, mv - 1, n);
            if(res != Integer.MIN_VALUE){
                max = Math.max(max, res);
            }
        }
        
        if(max != Integer.MIN_VALUE){
            max += f[r][c];
        }
        
        return m2[r][c] = max;
    }
    
    public int dp3(int r, int c, int[][] f, int mv, int n){
        if(r == n-1 && c == n-1){
            return f[r][c];
        }
        
        if(r < 0 || r >= n || c >= n || mv <= 0){
            return Integer.MIN_VALUE;
        }
        
        if(r == c && !(r == n-1 && c == n-1)){
            return Integer.MIN_VALUE;
        }
        
        if(m2[r][c] != -1){
            return m2[r][c];
        }
        
        int max = Integer.MIN_VALUE;
        
        if(r - 1 >= 0 && c + 1 < n){
            int res = dp3(r - 1, c + 1, f, mv - 1, n);
            if(res != Integer.MIN_VALUE){
                max = Math.max(max, res);
            }
        }
        
        if(c + 1 < n){
            int res = dp3(r, c + 1, f, mv - 1, n);
            if(res != Integer.MIN_VALUE){
                max = Math.max(max, res);
            }
        }
        
        if(r + 1 < n && c + 1 < n){
            int res = dp3(r + 1, c + 1, f, mv - 1, n);
            if(res != Integer.MIN_VALUE){
                max = Math.max(max, res);
            }
        }
        
        if(max != Integer.MIN_VALUE){
            max += f[r][c];
        }
        
        return m2[r][c] = max;
    }
}