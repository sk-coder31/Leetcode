class Solution {
    public long maxProduct(int[] nums) {
        if (nums.length < 2) return 0L;
        long a = 0L, b = 0L;
        for (int x : nums) {
            long v = Math.abs((long)x); 
            if (v > a) {
                b = a;
                a = v;
            } else if (v > b) {
                b = v;
            }
        }
        return 100000L * a * b;
    }
}