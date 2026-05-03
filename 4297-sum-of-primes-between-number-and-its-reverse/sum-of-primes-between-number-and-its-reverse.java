class Solution {
    public int sumOfPrimesInRange(int n) {
        int original = n;
        int reversed = 0;
        
        while (n > 0) {
            int temp = n % 10;
            reversed = reversed * 10 + temp;
            n = n / 10;
        }

        int l = Math.min(original, reversed);
        int r = Math.max(original, reversed);

        int sum = 0;

        while (l <= r) {
            if (check(l)) {
                sum += l;
            }
            l++;
        }

        return sum;
    }

    public boolean check(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}