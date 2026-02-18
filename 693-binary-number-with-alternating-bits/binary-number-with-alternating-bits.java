class Solution {
    public boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        boolean togg = str.charAt(0)=='0' ? true : false;
        for(int i = 1 ; i < str.length() ; i++){
            if(str.charAt(i)=='0' && !togg){
                togg = !togg;
            }else if(str.charAt(i)=='1' && togg){
                togg = !togg;
            }else{
                return false;
            }
        }
        return true;
    }
}