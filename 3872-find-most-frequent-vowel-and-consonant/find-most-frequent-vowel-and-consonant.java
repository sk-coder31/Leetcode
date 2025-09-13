class Solution {
    public int maxFreqSum(String s) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            int n = ch - 'a';
            arr[n] = arr[n] + 1;
        }
       HashSet<Character> hs = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count_v = 0;
        int count_c = 0;
        for(char ch : s.toCharArray()){
            if(hs.contains(ch)){
                count_v = Math.max(count_v,arr[ch-'a']);
            }else{
                count_c = Math.max(count_c,arr[ch-'a']);
            }
        }
        return count_v+count_c;

    }
}