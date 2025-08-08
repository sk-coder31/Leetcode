class Solution {
    HashMap<String,Double>hm = new HashMap<>();
    public double soupServings(int n) {
        if (n >= 4800) return 1.0;
        double res = dp(n,n);
        return res;
    }
    public double dp(int a,int b){
        int soupA = Math.max(a,0);
        int soupB = Math.max(b,0);
        String key = a+","+b;
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        if(soupA==0 && soupB==0){
            return 0.5;
        }
        if(soupA==0 && soupB>=1){
            return 1.0;
        }
        if(soupA>=1 && soupB==0){
            return 0;
        }
        double op1 = dp(a-100,b);
        double op2 = dp(a-75,b-25);
        double op3 = dp(a-50,b-50);
        double op4 = dp(a-25,b-75);
        hm.put(key,0.25 * (op1+op2+op3+op4));
        return hm.get(key);
    }
}