class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int max = 0;
        String ans = "";
        String f = "";
        for(int i = 0 ; i < n-2 ; i++){
            char a = num.charAt(i);
            char b = num.charAt(i+1);
            char c = num.charAt(i+2);
            if(a==b && b==c){
                ans+=a;
                ans+=b;
                ans+=c;
                int val = Integer.parseInt(ans);
                System.out.println(val);
                if(val>=max){
                    max = val;
                    f = ans;
                }
                ans="";
            }
        }
        return f;
    }
}