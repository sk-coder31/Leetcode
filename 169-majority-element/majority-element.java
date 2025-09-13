class Solution {
    public int majorityElement(int[] nums) {
        Random random = new Random();
        int n = nums.length;

        while (true) {
            int count = 0;
            int candidate = nums[random.nextInt(n)];
            for (int i = 0; i < n; i++) {
                if (nums[i] == candidate) {
                    count++;
                }
                if (count > n / 2) {
                    return candidate;
                }
            }
        }
    }
}