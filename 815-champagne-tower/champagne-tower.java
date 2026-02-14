class Solution {
    double[][] dp; 

    public double champagneTower(int poured, int query_row, int query_glass) {
        dp = new double[101][101];
        for (double[] row : dp) Arrays.fill(row, -1.0); 
        return Math.min(1.0, helper(poured, query_row, query_glass));
    }

    private double helper(int poured, int row, int col) {
        
        if (row == 0 && col == 0) return poured;
        
        
        if (col < 0 || col > row) return 0;

        
        if (dp[row][col] != -1.0) return dp[row][col];

        
        double left = Math.max(0.0, (helper(poured, row - 1, col - 1) - 1) / 2.0);
        double right = Math.max(0.0, (helper(poured, row - 1, col) - 1) / 2.0);
        return dp[row][col] = left + right;
    }
}
