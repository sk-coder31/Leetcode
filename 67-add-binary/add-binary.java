class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sc = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            int n = (i >= 0) ? a.charAt(i) - '0' : 0;
            int m = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = n + m + carry;
            
            if (sum == 2) {
                carry = 1;
                sc.append("0");
            } else if (sum == 3) {
                carry = 1;
                sc.append("1");
            } else if (sum == 0) {
                carry = 0;
                sc.append("0");
            } else if (sum == 1) {
                carry = 0;
                sc.append("1");
            }
            
            i--;
            j--;
        }

        if (carry != 0) {
            sc.append("1");
        }
        
        return sc.reverse().toString();
    }
}
