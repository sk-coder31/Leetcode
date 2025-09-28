class Solution {
    int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return dp(0, arr, k);
    }
    public int dp(int idx, int[] arr, int k) {
        if (idx >= arr.length) return 0;
        if (memo[idx] != -1) return memo[idx];

        int max = 0, total = 0;
        for (int i = idx; i < Math.min(idx + k, arr.length); i++) {
            max = Math.max(max, arr[i]);
            total = Math.max(total, max * (i - idx + 1) + dp(i + 1, arr, k));
        }

        return memo[idx] = total;
    }
}
