class Solution {
    int limit;
    int mod = 1_000_000_007;
    int[][][][] dp;
    public int numberOfStableArrays(int zero, int one, int limit) {
        this.dp = new int[zero+1][one+1][3][Math.max(one,zero)+1];
        for(int[][][] arr : dp){
            for(int[][] arr1: arr){
                for(int[] arr2 : arr1){
                    Arrays.fill(arr2,-1);
                }
            }
        }
        this.limit = limit;
        return helper(zero,one,-1,0);
    }
    public int helper(int zero,int one,int last,int repeat){
        if(one == 0 && zero == 0){
            return 1;
        }
        if(dp[zero][one][last+1][repeat]!=-1){
            return dp[zero][one][last+1][repeat];
        }
        int count = 0;
        if(zero > 0){
            if(last == 0){
                if(repeat < limit){
                    count = (count + helper(zero-1,one,0,repeat+1))%mod;
                }
            }else{
                count  = (count + helper(zero-1,one,0,1))%mod;
            }
        }
        if(one > 0){
            if(last == 1){
                if(repeat < limit){ 
                    count = (count + helper(zero,one-1,1,repeat+1))%mod;
                }
            }else{
                count = (count + helper(zero,one-1,1,1))%mod;
            }
        }
        return dp[zero][one][last+1][repeat] = count;
    }
}