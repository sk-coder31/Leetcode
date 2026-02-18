class Solution {
    long[] memo;
    public long rob(int[] nums, int[] colors) {
        this.memo = new long[nums.length];
        Arrays.fill(memo, -1);
        return helper(0, nums, colors);
    }

    public long helper(int curr, int[] nums, int[] colors) {
        if (curr >= nums.length) return 0;

        if (memo[curr] != -1) return memo[curr];

        long skip = helper(curr + 1, nums, colors);
        long take;

        if (curr + 1 < nums.length && colors[curr] == colors[curr+1]) {
            take = nums[curr] + helper(curr + 2, nums, colors);
        } else {
            take = nums[curr] + helper(curr + 1, nums, colors);
        }

        return memo[curr] = Math.max(take, skip);
    }
}
