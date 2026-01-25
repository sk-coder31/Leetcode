class Solution {
    public int minimumPrefixLength(int[] nums) {
        int b = -1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i]<=nums[i-1]){
                b = i;
            }
        }
        return b==-1 ? 0 : b;
    }
}