class Solution {
    public int maximumLength(int[] nums) {
        int countodd = 0;
        int counteven = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 !=0){
                countodd++;
            }else{
                counteven++;
            }
        }

        int parity = nums[0]%2;
        int count = 1;
        for(int i = 1 ; i < nums.length ; i++){
            int curr_parity = nums[i] % 2;
            if(curr_parity != parity){
                count++;
                parity = curr_parity;
            }
        }
        return Math.max(countodd,Math.max(counteven,count));
    }
}