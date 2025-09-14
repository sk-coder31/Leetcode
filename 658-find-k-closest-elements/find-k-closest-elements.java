class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->{
            int diff1 = Math.abs(a-x);
            int diff2 = Math.abs(b-x);
            if(diff1==diff2){
                if(a<b){
                    return -1;
                }else{
                    return 1;
                }
            }
            return Integer.compare(diff1,diff2);
        });
        for(int i : arr){
            pq.add(i);
        }
        //System.out.println(pq);
        List<Integer>res = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}