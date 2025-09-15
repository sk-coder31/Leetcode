class Solution {
    int mod = 1_000_000_007;
    int[][][] memo;
    public int countStableSubsequences(int[] nums) {
        int prev_parity = -1;
        int prev2_parity = -1;
        int idx = 0;
        memo = new int[nums.length][3][3];
        for(int[][] arr : memo){
            for(int[] ar:arr){
                Arrays.fill(ar,-1);
            }
        }
        return dp(idx,prev_parity,prev2_parity,nums)%mod-1;
    }
    public int dp(int idx,int prev_parity,int prev2_parity,int[] nums){
        if(nums.length == idx){
            return 1;
        }
        if(memo[idx][prev_parity+1][prev2_parity+1]!=-1){
            return memo[idx][prev_parity+1][prev2_parity+1];
        }
        int res = 0;
        res += (dp(idx+1,prev_parity,prev2_parity,nums))%mod;
        int curr_parity = nums[idx] % 2;
        if(!(curr_parity == prev_parity && curr_parity == prev2_parity) ||(prev_parity == -1 || prev2_parity == -1)){
            res += (dp(idx+1,curr_parity,prev_parity,nums))%mod;
        }
        return memo[idx][prev_parity+1][prev2_parity+1] = res;
    }
}