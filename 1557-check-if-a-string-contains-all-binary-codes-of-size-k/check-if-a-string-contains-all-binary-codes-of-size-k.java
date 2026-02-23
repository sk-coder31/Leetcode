class Solution {
    public boolean hasAllCodes(String s, int k) {
        long val = (long) Math.pow(2, k);
        HashSet<String> hs = new HashSet<>();
        for (int i = k; i <=s.length(); i++) {
            String str = s.substring(i-k,i);
            hs.add(str);
        }
        if((long)hs.size() == val){
            return true;
        }
        return false;
    }
}