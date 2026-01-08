class Solution {
    Integer[][] memo;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.memo = new Integer[nums1.length][nums2.length];
        int i = 0;
        int j = 0;
        return helper(i,j,nums1,nums2);
    }
    public int helper(int i,int j,int[] nums1,int[] nums2){
        if(i>=nums1.length || j>=nums2.length){
            return Integer.MIN_VALUE;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        int left = helper(i+1,j,nums1,nums2);
        int right = helper(i,j+1,nums1,nums2);

        int both = nums1[i] * nums2[j] + Math.max(0,helper(i+1,j+1,nums1,nums2));
        return memo[i][j] = Math.max(left,Math.max(both,right));
    }
}