class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            pq.add(i);
        }
        HashSet<Integer>hs = new HashSet<>();
        List<Integer>arr = new ArrayList<>();
        int idx = 0;
        while(!pq.isEmpty()){
            if(idx==k){
                break;
            }
            int val = pq.poll();
            if(hs.contains(val)){
                continue;
            }else{
                arr.add(val);
                hs.add(val);
            }
            idx++;
        }
        idx = 0;
        int[] res = new int[arr.size()];
        for(int i : arr){
            res[idx++] = i;
        }
        return res;

    }
}