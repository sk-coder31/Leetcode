class Solution {
    public boolean partitionArray(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        if (nums.length % k != 0 ) {
            return false;
        } else {
            for (int i = 0; i < nums.length; i++) {
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            }
            for (int key : hm.keySet()) {
                if (hm.get(key) <= nums.length/k) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}