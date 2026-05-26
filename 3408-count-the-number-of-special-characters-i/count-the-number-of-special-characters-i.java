class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer>hm = new HashMap<>();
        for(char ch : word.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int val = 0;
        for(char ch : hm.keySet()){
            if(Character.isLowerCase(ch)){
                char upper = Character.toUpperCase(ch);
                if(hm.containsKey(upper)){
                    val += 1;
                }
            }
        }
        return val;
    }
}