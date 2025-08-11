class Solution {
    int mod = 1_000_000_007;
    private long modPow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
    public int[] productQueries(int n, int[][] queries) {
        String str = Integer.toBinaryString(n);
        List<Integer> ls = new ArrayList<>();
        int size = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                ls.add(0, (int) Math.pow(2, size));
            }
            size--;
        }
        long[] prefix = new long[ls.size()];
        long val = 1;
        for (int i = 0; i < ls.size(); i++) {
            val = (val * ls.get(i)) % mod;
            prefix[i] = val;
        }

        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int l = queries[k][0];
            int r = queries[k][1];

            if (l == 0) {
                ans[k] = (int) (prefix[r] % mod);
            } else {
                long numerator = prefix[r];
                long denominator = prefix[l - 1];
                long inv = modPow(denominator, mod - 2); 
                ans[k] = (int) ((numerator * inv) % mod);
            }
        }
        return ans;
    }
}
