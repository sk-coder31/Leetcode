class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        String str_l = moves.replaceAll("_","R");
        String str_r = moves.replaceAll("_","L");
        int max = Math.max(check(str_l),check(str_r));
        return max;
    }
    public int check(String str){
        int dist = 0;
        for(char ch : str.toCharArray()){
            if(ch == 'L'){
                dist = dist - 1;
            }else{
                dist = dist + 1;
            }
        }
        return Math.abs(dist);
    }
}