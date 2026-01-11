class Solution {
    public int residuePrefixes(String s) {
        int count = 0;
        for(int i = 0; i < s.length() ; i++){
            HashSet<Character>hs = new HashSet<>();
            int len = 0;
            for(int j = 0 ; j <=i ; j++){
                char ch = s.charAt(j);
                hs.add(ch);
                len++;
            }
            // System.out.println(hs);
            if(hs.size() == len%3){
                count++;
            }
        }
        return count;
    }
}