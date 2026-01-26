class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        HashMap<Integer,Integer>hm  = new HashMap<>();
        for(int i : arr){
            hm.put(i,1);
        }
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < arr.length ; i++){
            min = Math.min(min,Math.abs(arr[i-1]-arr[i]));
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(hm.containsKey(arr[i]-min)){
                res.add(Arrays.asList(arr[i]-min,arr[i]));
            }
        }
        return res;
    }
}