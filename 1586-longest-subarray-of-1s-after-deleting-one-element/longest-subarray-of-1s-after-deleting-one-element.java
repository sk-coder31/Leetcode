class Solution {
    public int longestSubarray(int[] nums) {
        int l= 0;
        int r = 0;
        int maxlen = 0;
        int count = 0;
        while(r<nums.length){
            if(nums[r]==0){
                count++;
            }
            while(count>1){
                if(nums[l]==0){
                    count--;
                }
                l++;
            }
            maxlen = Math.max(r-l,maxlen);
            r++;
        }
        return maxlen;
        
    }
}