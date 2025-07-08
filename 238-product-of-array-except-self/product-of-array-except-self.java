class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            prefix[i] = prefix[i-1] * nums[i];
        }

        suffix[n-1] = nums[n-1];
        for(int i = n-2 ; i>=0 ; i--){
            suffix[i] = suffix[i+1] * nums[i];
        }

        for(int i = 0 ; i < nums.length ; i++){
            int left = 1;
            int right = 1;
            if(i-1>=0){
                 left = prefix[i-1];
            }
            if(i+1<n){
                 right = suffix[i+1];
            }
            nums[i] = left * right;
        }
        return nums;
    }

}