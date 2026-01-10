class Solution {
    int[][] dp;
    //delete --> let
    //leet --> e
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        int i = 0;
        int j = 0;
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int sum = lcs(0,0,s1,s2);
        return asciisum(s1) + asciisum(s2) - 2*sum;
    }
    public int asciisum(String s){
        int sum = 0;
        for(int i = 0; i < s.length() ; i++){
            sum += (int)s.charAt(i);
        }
        return sum;
    }
    public int lcs(int i,int j,String s1,String s2){
        if(i>=s1.length() || j>=s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = (int)s1.charAt(i) + lcs(i+1,j+1,s1,s2);
        }else{
            dp[i][j] = Math.max(lcs(i+1,j,s1,s2),lcs(i,j+1,s1,s2));
        }
        return dp[i][j];
    }
}