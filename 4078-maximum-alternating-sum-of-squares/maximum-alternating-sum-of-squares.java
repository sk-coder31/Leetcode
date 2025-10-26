class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int start = 0;
        int end = nums.length - 1;
        long sum = 0;
        while(start < end){
            long val1 = (long)nums[end];
            long val2 = (long)nums[start];
            sum += (val1*val1);
            sum -= (val2*val2);
            start++;
            end--;
        }
        if(nums.length%2!=0){
            sum += (nums[end]*nums[end]);
        }
        return sum;
    }
}