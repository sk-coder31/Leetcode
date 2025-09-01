class Solution {
    int len;
    int[][] memo;
    public int countArrangement(int n) {
        this.len = n;
        memo = new int[n+1][1 << n]; 
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dp(1, 0);
    }

    public int dp(int val, int mask) {
        if (val == len + 1) {
            return 1; 
        }

        if (memo[val][mask] != -1) {
            return memo[val][mask];
        }

        int sum = 0;
        for (int i = 1; i <= len; i++) {
            if ((mask & (1 << (i - 1))) == 0) { 
                if (val % i == 0 || i % val == 0) {
                    sum += dp(val + 1, mask | (1 << (i - 1)));
                }
            }
        }
        return memo[val][mask] = sum;
    }
}
