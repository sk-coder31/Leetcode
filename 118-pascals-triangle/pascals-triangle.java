class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>res = new ArrayList<>();
        for(int i = 0 ; i < numRows ; i++){
            List<Integer>ps = new ArrayList<>();
            for(int j = 0 ; j <= i ; j++){
                if(j==0 || j == i){
                    ps.add(1);
                }else{
                    List<Integer>prev = res.get(i-1);
                    int val = prev.get(j)+prev.get(j-1);
                    ps.add(val);
                }
            }
            res.add(ps);
        }
        return res;
    }
}