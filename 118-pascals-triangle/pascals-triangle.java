class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>arr = new ArrayList<>();
        for(int i = 0 ; i < numRows ; i++){
            List<Integer>res = new ArrayList<>();
            for(int j = 0 ; j <= i ; j++){
                if(j==0 || j==i){
                    res.add(1);
                }else{
                    List<Integer>prev = arr.get(i-1);
                    res.add(prev.get(j-1)+prev.get(j));
                    
                }
            }

            arr.add(res);
        }
        return arr;
    }
}