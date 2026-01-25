class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < k ; i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int diff = Integer.MAX_VALUE;
        diff = Math.min(diff,max-min);
        for(int i = 1; i < nums.length - k +1; i++){
            int a = nums[i];
            int b = nums[i+k-1];
            // System.out.println(a+" "+b);
            diff = Math.min(diff,b-a);
        }
        return diff;
    }
}