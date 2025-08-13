class Solution {
    int[][] memo;
    int maxlen = 0;
    public int findLength(int[] nums1, int[] nums2) {
        memo = new int[nums1.length + 1][nums2.length + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                dp(i, j, nums1, nums2);
            }
        }

        return maxlen;
    }

    public int dp(int i, int j, int[] nums1, int[] nums2) {
        if (i >= nums1.length || j >= nums2.length) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int len = 0;
        if (nums1[i] == nums2[j]) {
            len = 1 + dp(i + 1, j + 1, nums1, nums2);
            maxlen = Math.max(maxlen, len);
        }
        return memo[i][j] = len;
    }
}
