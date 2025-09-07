class Solution {
    public int minOperations(String s) {
        int max = 0;
        for(int i = 0 ;  i < s.length() ; i++){
            int val = (int)s.charAt(i);
            int moves = (26- (val - 97))%26;
            max = Math.max(max,moves);
        }
        return max;
    }
}