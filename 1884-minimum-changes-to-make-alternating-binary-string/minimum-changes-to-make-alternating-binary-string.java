class Solution {
    public int minOperations(String s) {
        return helper(s);
    }
    public int helper(String s){
        boolean isZero = true;
        int count1 = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i)=='0' && isZero){
                isZero = !isZero;
                continue;
            }else if(s.charAt(i)=='1' && !isZero){
                isZero = !isZero;
                continue;
            }else{
                count1++;
                isZero = !isZero;
            }
        }
        boolean isOne = true;
        int count2 = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i)=='1' && isOne){
                isOne = !isOne;
                continue;
            }else if(s.charAt(i)=='0' && !isOne){
                isOne = !isOne;
                continue;
            }else{
                isOne = !isOne;
                count2++;
            }
        }
        return Math.min(count1,count2);
    }
}