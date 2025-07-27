class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(nums));
        long sum = 0;
        int no = nums.length/3;
        for (int i = 1; i < n-1; i += 2) {
            if(no==0)break;
            sum += nums[i];
            no--;
        }

        return sum;
    }
}
