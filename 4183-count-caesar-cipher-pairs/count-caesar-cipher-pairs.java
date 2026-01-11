class Solution {
    public long countPairs(String[] words) {
        long count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(String str : words) {
            String key = can(str);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // System.out.println(hm);
        for(int freq : map.values()) {
            count += (long) freq * (freq - 1) / 2;
        }
        return count;
    }

    private String can(String s) {
        int shift = s.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char canon = (char)((c - shift - 'a' + 26) % 26 + 'a');
            sb.append(canon);
        }
        return sb.toString();
    }
}
