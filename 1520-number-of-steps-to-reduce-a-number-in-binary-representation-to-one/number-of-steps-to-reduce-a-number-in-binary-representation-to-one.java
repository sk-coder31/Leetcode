class Solution {
    public int numSteps(String s) {
        String r = "1";
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        while (!r.equals(sb.toString())) {
            if (sb.charAt(sb.length() - 1) == '1') {
                int i = sb.length() - 1;
                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }
                if (i >= 0) {
                    sb.setCharAt(i, '1');
                } else {
                    sb.insert(0, '1');
                }
                count++;

            } else {
                sb.deleteCharAt(sb.length() - 1);
                count++;
            }
        }

        return count;
    }
}