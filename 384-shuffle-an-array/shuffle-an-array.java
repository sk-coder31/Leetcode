class Solution {
    Random rand ;
    List<Integer>arr = null;
    List<Integer>no_change = null;
    public Solution(int[] nums) {
        arr = new ArrayList<>();
        no_change = new ArrayList<>();
        rand = new Random();
        for(int i : nums){
            arr.add(i);
            no_change.add(i);
        }
    }
    
    public int[] reset() {
        int[] res = new int[arr.size()];
        for(int i = 0 ; i < arr.size() ; i++){
            res[i] = no_change.get(i);
        }
        return res;
    }
    
    public int[] shuffle() {
        Collections.shuffle(arr,rand);
        int[] res = new int[arr.size()];
        for(int i = 0 ; i < arr.size() ; i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}

