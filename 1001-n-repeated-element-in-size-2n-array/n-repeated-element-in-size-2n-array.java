class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int val = 0;    
        for(int key : hm.keySet()){
            if(hm.get(key)==n){
                val = key;
            }
        }
        return val;
    }
}