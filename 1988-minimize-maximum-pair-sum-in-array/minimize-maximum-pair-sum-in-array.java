class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int max = 0;
        while(i <= j){
            int start = nums[i];
            int end = nums[j];
            max = Math.max(end+start,max);
            i++;
            j--;
        }
        return max;
    }
}