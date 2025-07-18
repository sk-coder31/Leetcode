class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer>hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int total = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(i+1 < s.length() && hm.get(ch)<hm.get(s.charAt(i+1))){
                total -= hm.get(ch);
            }else{
                total += hm.get(ch);
            }
        }
        return total;
    }
}