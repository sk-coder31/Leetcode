class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sc = new StringBuilder(s);
        while(sc.length()!=2){
            String str = sc.toString();
            StringBuilder temp = new StringBuilder();
            for(int i = 1 ; i < str.length() ; i++){
                int n1 = (int)(str.charAt(i-1)-'0');
                int n2 = (int)(str.charAt(i)-'0');
                int a = (n1+n2)%10;
                char sd = Character.forDigit(a,10);
                temp.append(sd);
            }
            sc = temp;
        }
        String ss = sc.toString();
        return ss.charAt(0)==ss.charAt(1);
    }
}