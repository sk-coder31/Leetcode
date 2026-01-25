class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) arr.add(nums[i]);
        }
        if(arr.size() > 0) {
            k = k % arr.size(); 
            arr = rotateLeft(arr, k);
        }
        
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                nums[i] = arr.get(j);
                j++;
            }
        }
        
        return nums;
    }
    
    public List<Integer> rotateLeft(List<Integer> arr, int k) {
        if(k == 0 || arr.size() == 0) return arr;
        
        List<Integer> rotated = new ArrayList<>();
        int n = arr.size();
        for(int i = k; i < n; i++) {
            rotated.add(arr.get(i));
        }
        for(int i = 0; i < k; i++) {
            rotated.add(arr.get(i));
        }
        
        return rotated;
    }
}
