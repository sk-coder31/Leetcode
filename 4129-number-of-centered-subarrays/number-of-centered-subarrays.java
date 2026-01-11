class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;

        int[] prefix = new int[n+1];
        for(int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }

        for(int l = 0; l < n; l++) {
            HashMap<Integer,Integer> freq = new HashMap<>();
            for(int r = l; r < n; r++) {
                int sum = prefix[r+1] - prefix[l];
                freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

                if(freq.containsKey(sum)) {
                    count++;
                }
            }
        }
        return count;
    }
}
