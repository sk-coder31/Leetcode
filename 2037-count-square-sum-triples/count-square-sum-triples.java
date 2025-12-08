class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                int rem = i*i + j*j;
                int c = (int)Math.sqrt(rem);
                if(c<=n && c*c == i*i +j*j){
                    count++;
                }
            }
        }
        return count;
    }
}