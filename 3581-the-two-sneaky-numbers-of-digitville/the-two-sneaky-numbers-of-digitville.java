class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        //System.out.println(hm);
        List<Integer>arr = new ArrayList<>();
        for(int i : nums){
            if(hm.get(i)==2){
                if(!arr.contains(i))
                arr.add(i);
            }
        }
        int[] res = new int[arr.size()];
        for(int i = 0 ; i < arr.size() ; i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}