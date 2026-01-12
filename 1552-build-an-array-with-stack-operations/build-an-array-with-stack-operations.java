class Solution {
    public List<String> buildArray(int[] target, int n) {
        int curr_num = 1;
        List<String>arr = new ArrayList<>();
        int i = 0;
        while(i < target.length){
            // System.out.println(curr_num +" "+target[i]);
            if(target[i] == curr_num){
                arr.add("Push");
                i++;
                
            }else{
                arr.add("Push");
                arr.add("Pop");
            }
            curr_num++;
        }
        return arr;
    }
}