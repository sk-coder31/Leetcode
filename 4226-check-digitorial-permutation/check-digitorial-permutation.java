class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] memo = {1,1,2,6,24,120,720,5040,40320,362880};
        
        long temp = n;
        long sum = 0;
        while(n != 0){
            int r = n % 10;
            sum += memo[r];
            n = n / 10;
        }
        if(sum == temp) return true;

        long check = sum;
        long verify = 0;
        
        while(check != 0){
            int r = (int)(check % 10);
            verify += memo[r];
            check /= 10;
        }
        
        if(verify != sum) return false;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        long t = temp;
        while(t != 0){
            int r = (int)(t % 10);
            hm.put(r, hm.getOrDefault(r, 0) + 1);
            t /= 10;
        }

        long s = sum;
        while(s != 0){
            int r = (int)(s % 10);
            hm.put(r, hm.getOrDefault(r, 0) - 1);
            s /= 10;
        }

        for(int val : hm.values()){
            if(val != 0) return false;
        }

        return true;
    }
}