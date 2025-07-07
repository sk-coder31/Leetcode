class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer>freq = new HashMap<>();
        HashMap<Integer,Integer>valid = new HashMap<>();
        for(int num : nums){
            freq.put(num , freq.getOrDefault(num , 0)+1);
        }
        for(int num : nums){
            if(freq.getOrDefault(num,0)==0){
                continue;
            }
            if(valid.getOrDefault(num-1,0) > 0){
                valid.put(num-1,valid.getOrDefault(num-1,0)-1);
                valid.put(num,valid.getOrDefault(num,0)+1);
                freq.put(num,freq.getOrDefault(num,0)-1);
            }
            else if(freq.getOrDefault(num + 1,0)>0 && freq.getOrDefault(num+2,0)>0){
                freq.put(num,freq.getOrDefault(num,0)-1);
                freq.put(num+1,freq.getOrDefault(num+1,0)-1);
                freq.put(num+2,freq.getOrDefault(num+2,0)-1);
                valid.put(num+2,valid.getOrDefault(num+2,0)+1);
            }else{
                return false;
            }
        }
        return true;
    }
}