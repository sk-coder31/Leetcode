class Solution {
    public int countBinarySubstrings(String s) {
        int prev_count = 0;
        int curr_count = 1;
        int res = 0;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i)==s.charAt(i-1)){
                curr_count++;
            }else{
                res += Math.min(curr_count,prev_count);
                prev_count = curr_count;
                curr_count = 1;
            }
        }
        return res+Math.min(curr_count,prev_count);
    }
}