class Solution {
    int mod = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long result = 0;
        int digits = 0;

        for (int i = 1; i <= n; i++) {

            if ((i & (i - 1)) == 0) {
                digits++;
            }

            result = ((result << digits) + i) % mod;
        }

        return (int) result;
    }
}