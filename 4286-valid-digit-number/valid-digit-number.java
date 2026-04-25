class Solution {
    public boolean validDigit(int n, int x) {
        String str = Integer.toString(n);
        char ch = (char)(x + '0');  
        
        if (str.indexOf(ch) >= 1) {
            return true;
        }
        return false;
    }
}