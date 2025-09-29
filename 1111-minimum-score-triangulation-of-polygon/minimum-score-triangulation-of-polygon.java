class Solution {
    int[][] memo;
    public int minScoreTriangulation(int[] values) {
        int i = 0;
        int n = values.length;
        memo = new int[n][n];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return dp(i,n-1,values);
    }
    public int dp(int i,int j,int[] arr){
        if(j-i+1<3){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i+1 ; k < j ; k++){
            int wt = arr[i]*arr[j]*arr[k]+dp(i,k,arr) + dp(k,j,arr);
            min = Math.min(wt,min);
        }
        return memo[i][j] = min;
    }
}