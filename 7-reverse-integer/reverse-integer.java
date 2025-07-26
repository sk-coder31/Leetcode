class Solution {
    public int reverse(int x) {
        long num = 0; 
        int len = Integer.toString(Math.abs(x)).length() - 1;

        while (len >= 0) {
            int r = x % 10;
            x = x / 10;
            long res = (long) r * (long) Math.pow(10, len);
            num += res;

            len--;
        }

        // Check for 32-bit integer overflow
        if (num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) return 0;
        return (int) num;
    }
}
