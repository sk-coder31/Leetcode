class Solution {
    public boolean hasAllCodes(String s, int k) {
        int val = (1<<k);
        HashSet<String> hs = new HashSet<>();
        for (int i = k; i <=s.length(); i++) {
            String str = s.substring(i-k,i);
            if(hs.contains(str)){
                continue;
            }else{
                val--;
                hs.add(str);
            }
        }
        return val == 0;
    }
}