class Solution {
    public char findKthBit(int n, int k) {
        return helper(n, k);
    }

    public char helper(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int len = (1 << n) - 1;
        int mid = (len+1)/2;
        if (k < mid) {
            return helper(n - 1, k);
        } else if (k == mid) {
            return '1';
        } else {
            char ch = helper(n - 1, len - (k - 1));
            if (ch == '0') {
                return '1';
            }
            else {
                return '0';
            }

        }
    }
}

// S1 = "0"
// S2 = "0 1 1"
// S3 = "011 1 001"
// S4 = "0111001 1 0110001" n = 4 , k = 11

// n = 4 , k = 15 - (k-1) = 5 1

// n = 3 , k = 7 - (5-1) = 3 0

// n = 3   , k = 3/3 == 1