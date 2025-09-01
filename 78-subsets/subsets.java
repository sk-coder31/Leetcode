class Solution {
    int[] arr;
    List<List<Integer>>list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.arr = nums;
        int mask = 0;
        dp(0,mask);
        return list;
    }

    public void dp(int idx,int mask){
        if(idx==arr.length){
            List<Integer>rr = new ArrayList<>();
            for (int i = 0; i < 32; i++) {
                if ((mask & (1 << i)) != 0) {
                    rr.add(arr[i]);
                }
            }
            list.add(rr);
            return;
        }
        dp(idx+1,mask);
        dp(idx+1,mask|(1<<idx));
        return;

    }
}