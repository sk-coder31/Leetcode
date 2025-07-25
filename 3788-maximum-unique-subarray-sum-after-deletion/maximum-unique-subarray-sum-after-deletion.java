class Solution {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        HashSet<Integer>hs = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max,nums[i]);
            if(nums[i]>=0 && !hs.contains(nums[i])){
                sum += nums[i];
                hs.add(nums[i]);
            }
        }
        return max<0 ? max : sum;
    }
}