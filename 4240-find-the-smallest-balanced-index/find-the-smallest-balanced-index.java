class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i  = 1 ; i < nums.length ; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        int[] suffix = new int[nums.length];
        suffix[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length - 2 ; i>=0 ; i--){
            suffix[i] = suffix[i+1]*nums[i];
        }
        int idx = -1;
        for(int i = 1 ; i < nums.length ; i++){
            int prev = prefix[i-1];
            int next = (i+1>=nums.length) ? 1 : suffix[i+1];
            if(prev == next){
                return i;
            }
        }
        return idx;
    }
}