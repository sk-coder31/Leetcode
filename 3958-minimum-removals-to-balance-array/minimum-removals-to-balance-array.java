class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int len = 0;
        int maxlen = 0;
        while(right<nums.length){
            long val = (long)nums[left] * k;
            if(nums[right] > val){
                left++;
            }
            len = right-left+1;
            maxlen = Math.max(maxlen,len);
            right++;
        }
        return nums.length-maxlen;
    }
}