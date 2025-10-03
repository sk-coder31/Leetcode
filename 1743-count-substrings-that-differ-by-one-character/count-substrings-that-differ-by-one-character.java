class Solution {
    public int countSubstrings(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) { 
                String sub = s.substring(i, j);
                count += helper(sub, t);
            }
        }
        return count;
    }

    public int helper(String str, String t) {
        int len = str.length();
        int count = 0;
        for (int i = 0; i <= t.length() - len; i++) {
            String subs = t.substring(i, i + len);
            if (!str.equals(subs)) {
                int diff = 0;
                for (int k = 0; k < len; k++) {
                    if (str.charAt(k) != subs.charAt(k)) diff++;
                    if (diff > 1) break; 
                }
                if (diff == 1) count++;
            }
        }
        return count;
    }
}
