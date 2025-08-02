class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        }
        HashMap<Character,Integer>hm = new HashMap<>();
        int count = 1;
        int maxlen = 0;
        List<Integer>list = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            maxlen = Math.max(maxlen,map.get(ch));
            if(i==maxlen){
                maxlen = 0;
                list.add(count);
                count=0;
            }
            count++;
        }
        return list;
    }
}