class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int max = 0;
        while(i < nums1.length && j < nums2.length ){
            if(nums1[i]<=nums2[j]){
                j++;
            }else{
                i++;
            }
            System.out.println(max);
            max = Math.max((j-i),max);
        }
        max = Math.max((j-i),max);
        return max == 0 ? 0 : max-1;
    }
}
