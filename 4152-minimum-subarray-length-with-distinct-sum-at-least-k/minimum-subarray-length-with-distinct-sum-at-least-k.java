class Solution {
    public int minLength(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        HashMap<Integer,Integer>hm = new HashMap<>();
        while(r < n){
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            if(hm.get(nums[r])==1){
                sum += nums[r];
            }
            while(sum >= k){
                min = Math.min(min,r-l+1);
                hm.put(nums[l],hm.getOrDefault(nums[l],0)-1);
                if(hm.get(nums[l])==0){
                    sum -= nums[l];
                    hm.remove(nums[l]);
                }
                l++;
            }
            r++;
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
}