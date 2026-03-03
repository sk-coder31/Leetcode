class Solution {
    public char findKthBit(int n, int k) {
        String final_ans = helper(n);
        return final_ans.charAt(k-1);
    }
    public String helper(int n){
        if(n==1){
            return "0";
        }
        String prev_str = helper(n-1);
        String prev = prev_str + "1"+ rev_in(prev_str);
        return prev;
    }
    public String rev_in(String s){
        StringBuilder sc = new StringBuilder();
        for(int i = s.length()-1 ; i>=0 ; i--){
            if(s.charAt(i)=='0'){
                sc.append("1");
            }else{
                sc.append("0");
            }
        }
        return sc.toString();
    }
}