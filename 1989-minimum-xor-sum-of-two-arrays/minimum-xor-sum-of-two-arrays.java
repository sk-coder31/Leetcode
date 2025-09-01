class Solution {
    int[][] memo;
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int idx = 0;
        int mask = 0;
        memo = new int[nums1.length+1][1<<nums2.length];
        for(int[] i : memo){
            Arrays.fill(i,-1);
        }
        return dp(idx, mask, nums1, nums2);
    }

    public int dp(int idx, int mask, int[] nums1, int[] nums2) {
        if (idx == nums1.length) {
            return 0;
        }
        if(memo[idx][mask]!=-1){
            return memo[idx][mask];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            if ((mask & (1 << i)) == 0) {
                int sum = (nums1[idx] ^ nums2[i]) + dp(idx + 1, mask | (1 << i), nums1, nums2);

                min = Math.min(min, sum);
            }
        }
        return memo[idx][mask] = min;
    }
}