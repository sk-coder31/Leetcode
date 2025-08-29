class Solution {
    int[][] memo;
    public int maxSatisfaction(int[] nums) {
        memo = new int[nums.length][nums.length+1];
        for(int[] i: memo){
            Arrays.fill(i,-1);
        }
        Arrays.sort(nums);
        return dp(0,1,nums);
    }
    public int dp(int i,int k,int[] nums){
        if(i==nums.length){
            return 0;
        }
        if(memo[i][k]!=-1){
            return memo[i][k];
        }
        int option1 = dp(i+1,k,nums);
        int option2 = nums[i]*k + dp(i+1,k+1,nums);
        return memo[i][k]=Math.max(option1,option2);
    }
}