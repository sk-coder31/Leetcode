class Solution {
    public int scoreDifference(int[] nums) {
        boolean firstActive = true;

        int sum_first = 0;
        int sum_second = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0){
                firstActive = !firstActive;
            }
            if(i % 6 == 5){
                firstActive = !firstActive;
            }
            if(firstActive){
                sum_first += nums[i];
            } else {
                sum_second += nums[i];
            }
        }

        return sum_first - sum_second;
    }
}