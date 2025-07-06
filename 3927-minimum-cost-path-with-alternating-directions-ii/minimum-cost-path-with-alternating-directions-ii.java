class Solution {
    int[] drow = {0, 1};
    int[] dcol = {1, 0};
    Long[][][] memo;
    public long minCost(int m, int n, int[][] waitCost) {
        memo = new Long[m][n][2];
        long entryCost = 1L; 
        return entryCost + dp(0, 0, waitCost, 1);
    }
    
    public long dp(int i, int j, int[][] waitCost, int second) {
        if (i == waitCost.length - 1 && j == waitCost[0].length - 1) {
            return 0; 
        }
        
        int timeIndex = second % 2; 
        if (memo[i][j][timeIndex] != null) return memo[i][j][timeIndex];
        long ans = Long.MAX_VALUE;
        if (second % 2 == 1) { 
            for (int k = 0; k < 2; k++) {
                int ni = i + drow[k];
                int nj = j + dcol[k];
                if (ni < waitCost.length && nj < waitCost[0].length) {
                    long moveCost = (long) (ni + 1) * (nj + 1); 
                    ans = Math.min(ans, moveCost + dp(ni, nj, waitCost, second + 1));
                }
            }
        } else { 
            ans = waitCost[i][j] + dp(i, j, waitCost, second + 1);
        }
        
        return memo[i][j][timeIndex] = ans;
    }
}