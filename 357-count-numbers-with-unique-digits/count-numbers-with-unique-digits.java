class Solution {
    int[][] cache;
    public int countNumbersWithUniqueDigits(int n) {
        cache = new int[(1<<10)+1][n+1];
        for(int[] arr : cache){
            Arrays.fill(arr,-1);
        }
        int bit = 0;
        int count = 1;
        boolean first = true;
        for(int i = 1 ; i <= n ; i++){
            count += dp(bit,i,first);
        }
        return count;
    }
    public int dp(int bit,int n,boolean first){
        if(n==0){
            return 1;
        }
        if(cache[bit][n]!=-1){
            return cache[bit][n];
        }
        int count = 0;
        for(int i = 0 ; i <= 9 ; i++){
            if ((bit & (1 << i)) == 0) {
                if(first == true && i == 0){
                    continue;
                }
                count += dp(bit | (1<<i),n-1,false);
            }
        }
        if(!first){
            cache[bit][n] = count;
        }
        return count;
    }
}