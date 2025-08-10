class Solution {
    public boolean reorderedPowerOf2(int n) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        while(n>0){
            int r = n%10;
            hm.put(r,hm.getOrDefault(r,0)+1);
            n = n/10;
        }
        for(int i = 0 ; i < 30 ; i++){
            HashMap<Integer,Integer>temp = new HashMap<>();
            int pow_2 = 1<<i;
            while(pow_2>0){
                int r = pow_2%10;
                temp.put(r,temp.getOrDefault(r,0)+1);
                pow_2 = pow_2 / 10;
            }
            if(hm.equals(temp))return true;
        }
        return false;
    }
}