class Solution {
    Integer[][] memo;
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        memo = new Integer[n][n];
        int ans = dp(0, 1, nums, target);
        return ans < 0 ? -1 : ans;
    }
    public int dp(int prev, int curr, int[] nums, int target) {
        if (prev == nums.length - 1) {
            return 0;
        }
        if (curr == nums.length) {
            return -100000;
        }
        if (memo[prev][curr] != null) {
            return memo[prev][curr];
        }
        int take = -100000;
        int skip = -100000;

        if (Math.abs(nums[prev] - nums[curr]) <= target) {
            take = 1 + dp(curr, curr + 1, nums, target);
        }

        skip = dp(prev, curr + 1, nums, target);

        return memo[prev][curr] = Math.max(take, skip);
    }
}