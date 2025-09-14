class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int max = 0;
        int j = 0;
        int maxlen = 0;
        for(int i = 0 ; i < s.length() ; i++){
            int size = i - j + 1;
            char ch = s.charAt(i);
            freq[ch-'A']+=1;
            max = count(freq);
            while(((i-j+1) - max)> k && j<s.length()){//1-1,2-2,3-2,4-3,5-3
                // System.out.println(j);
                freq[s.charAt(j)-'A']-=1;
                max = count(freq);
                j++;
            }
            maxlen = Math.max(i-j+1,maxlen);
        }
        return maxlen;
    }
    public int count(int[] freq){
        int max = 0;
        for(int i : freq){
            max = Math.max(i,max);
        }
        return max;
    }
}