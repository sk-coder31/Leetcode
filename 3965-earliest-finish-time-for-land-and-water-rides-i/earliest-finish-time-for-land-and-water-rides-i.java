class Solution {
    public int earliestFinishTime(int[] l_s, int[] l_d, int[] w_s, int[] w_d) {
        int n = l_s.length, m = w_s.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int ls = l_s[i], ld = l_d[i];
            for (int j = 0; j < m; j++) {
                int ws = w_s[j], wd = w_d[j];

                int we = ws + wd;
                int ls_after_w = Math.max(ls, we);
                int end1 = ls_after_w + ld;

                int le = ls + ld;
                int ws_after_l = Math.max(ws, le);
                int end2 = ws_after_l + wd;

                ans = Math.min(ans, Math.min(end1, end2));
            }
        }

        return ans;
    }
}
