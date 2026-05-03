class Solution {
    public boolean rotateString(String s, String goal) {
        String str = s+s;
        int len = s.length();
        while(len < str.length()){
            String sub = str.substring(len-s.length(),len);
            if(sub.equals(goal)){
                return true;
            }
            len++;
        }
        return false;
    }
}