class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for(int i = 0 ; i < nums.length; i++){
            if(prev == -1 && nums[i]==1){
                prev = i;
            }
            else if(prev!=-1 && nums[i]==1){
                int len = i-prev-1;
                // System.out.println(prev+ " " +len);
                prev = i;
                if(len < k)return false;
            }
        }
        return true;
    }
}