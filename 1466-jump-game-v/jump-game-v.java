class Solution {
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        dp = new int[arr.length];
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            max = Math.max(max,helper(i,arr,d));
        }
        return max;
    }
    public int helper(int start,int[] arr,int d){
        if(dp[start]!=0){
            return dp[start];
        }
        int max = 1;
        for(int x = 1 ; x<=d ; x++){
            int next = start + x;
            if(next>=arr.length){
                break;
            }else if(arr[next]>=arr[start]){
                break;
            }
            max = Math.max(max, 1 + helper(next, arr, d));
        }
        for(int x = 1 ; x<=d ; x++){
            int next = start - x;
            if(next<0){
                break;
            }else if(arr[next]>=arr[start]){
                break;
            }
            max = Math.max(max, 1 + helper(next, arr, d));
        }
        dp[start] = max;
        return max;
    }
}