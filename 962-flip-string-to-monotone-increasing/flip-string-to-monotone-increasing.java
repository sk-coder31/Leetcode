class Solution {
    int max = Integer.MAX_VALUE;
    int[][] memo;
    public int minFlipsMonoIncr(String s) {
        char[] str = s.toCharArray();
        int prev = 0;
        memo = new int[s.length()][2];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return dp(0,prev,str);
    }
    public int dp(int i,int prev,char[] s){
        if(i==s.length){
            return 0;
        }
        if(memo[i][prev]!=-1){
            return memo[i][prev];
        }
        int res = Integer.MAX_VALUE;
        if(s[i]=='0'){
            
            if(prev == 0){
                res = dp(i+1,0,s);
            }
            res = Math.min(1+dp(i+1,1,s),res);
        }else{
            res = Math.min(res, dp(i + 1, 1, s));

            if (prev == 0) {
                res = Math.min(res, 1 + dp(i + 1, 0, s));
            }
        }
        return memo[i][prev] = res;
    }
}