class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], nums[i]);
        }
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (prefix[i] - suffix[i] <= k) {
                return i; 
            }
        }
        return -1;
    }
}