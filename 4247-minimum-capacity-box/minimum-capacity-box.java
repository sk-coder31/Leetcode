class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int smallest =  Integer.MAX_VALUE;
        int idx = -1;
        for(int i = 0 ; i < capacity.length ; i++){
            if(capacity[i]>=itemSize && smallest>capacity[i]){
                smallest = Math.min(smallest,capacity[i]);
                idx = i;
            }
        }
        return idx;
    }
}