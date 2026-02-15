class Solution {
    long[][][] memo;
    long mod = Long.MIN_VALUE/4;
    public long maxScore(int[] nums1, int[] nums2, int k) {
        memo = new long[nums1.length][nums2.length][k+1];
        for(long[][] arr : memo){
            for(long[] i : arr){
                Arrays.fill(i,Long.MIN_VALUE);
            }
        }
        int i = 0;
        int j = 0;

        return helper(i,j,nums1,nums2,k);
    }
    public long helper(int i,int j,int[] nums1,int[] nums2,int k){
        if(k==0){
            return 0;
        }
        if(i>=nums1.length || j>=nums2.length){
            return mod;
        }
        if(memo[i][j][k]!=Long.MIN_VALUE){
            return memo[i][j][k];
        }
        
        long skip = Math.max(
            helper(i+1,j,nums1,nums2,k),
            helper(i,j+1,nums1,nums2,k));
            
        long takeNext = helper(i+1, j+1, nums1, nums2, k-1);
        long take = (takeNext == mod)
                ? mod
                : 1L * nums1[i] * nums2[j] + takeNext;

        return memo[i][j][k] = Math.max(skip,take);
    }
}