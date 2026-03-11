class Solution {
    public int bitwiseComplement(int n) {
        if(n== 0){
            return 1;
        }
        if (helper(n)) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            int val = n | i;
            if(helper(val)){
                return i;
            }
        }
        return 0;
    }
    public boolean helper(int n){
        return (n & (n + 1)) == 0;
    }
}