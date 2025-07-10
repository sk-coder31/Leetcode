class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefix_n = new int[n + 1];
        int[] suffix_y = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix_n[i + 1] = prefix_n[i] + (customers.charAt(i) == 'N' ? 1 : 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            suffix_y[i] = suffix_y[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        int min = Integer.MAX_VALUE;
        int best = 0;
        for (int i = 0; i <= n; i++) {
            int penalty = prefix_n[i] + suffix_y[i];
            if (penalty < min) {
                min = penalty;
                best = i;
            }
        }
        return best;
    }
}
