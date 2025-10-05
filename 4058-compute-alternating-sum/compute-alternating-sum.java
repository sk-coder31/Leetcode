class Solution {
    public int alternatingSum(int[] nums) {
        int sum = nums[0];
        boolean t = true;
        for(int i = 1 ; i < nums.length ; i++){
            if(t){
                sum += -nums[i];
                t = false;
            }else{
                sum += nums[i];
                t = true;
            }
        }
        return sum;
    }
}