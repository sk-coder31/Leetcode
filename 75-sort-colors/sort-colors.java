class Solution {
    public void sortColors(int[] nums) {
        int curr = 0;
        int low = 0;
        int high = nums.length - 1;
        while(curr <= high){
            if(nums[curr]==0){
                swap(low,curr,nums);
                low++;
                curr++;
            }else if(nums[curr]==1){
                curr++;
            }else if(nums[curr]==2){
                swap(curr,high,nums);
                high--;
                // curr++;
            }
        }
    }
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}