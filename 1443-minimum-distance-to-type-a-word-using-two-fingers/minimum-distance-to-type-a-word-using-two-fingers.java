class Solution {
    int[][][] dp;

    public int minimumDistance(String word) {
        dp = new int[301][27][27];
        for (int[][] arr : dp) {
            for (int[] ar : arr) {
                Arrays.fill(ar, -1);
            }
        }
        return helper(0, 26, 26, word);
    }

    public int helper(int idx, int f1, int f2, String word) {
        if (idx == word.length()) return 0;

        if (dp[idx][f1][f2] != -1) {
            return dp[idx][f1][f2];
        }

        int curr = word.charAt(idx) - 'A';

        int move1 = dist(curr, f1) + helper(idx + 1, curr, f2, word);
        int move2 = dist(curr, f2) + helper(idx + 1, f1, curr, word);

        return dp[idx][f1][f2] = Math.min(move1, move2);
    }

    public int dist(int x, int y) {
        if (x == 26 || y == 26) return 0;

        int r1 = x / 6, c1 = x % 6;
        int r2 = y / 6, c2 = y % 6;

        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}