public class Solution {
    private static final int MOD = 1_000_000_007;
    private int MAX;
    private int[] mem;

    private int count(int curr, int delay, int forget) {
        if (mem[curr] != -1) return mem[curr];

        long total = (curr + forget - 1 >= MAX) ? 1 : 0;
        for (int i = delay; i < forget; ++i) {
            if (curr + i > MAX) break;
            total = (total + count(curr + i, delay, forget)) % MOD;
        }
        mem[curr] = (int) total;
        return mem[curr];
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        MAX = n;
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return count(1, delay, forget);
    }
}
