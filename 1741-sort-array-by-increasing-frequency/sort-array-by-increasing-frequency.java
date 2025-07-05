class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i = 0 ; i< nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->{
            int freq1 = hm.get(a);
            int freq2 = hm.get(b);
            if(freq1==freq2){
                return Integer.compare(b,a);
            }else{
                return Integer.compare(freq1,freq2);
            }
        });
        for(int i : nums){
            pq.add(i);
        }
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = pq.poll();
        }
        return nums;
    }
}