class Solution {
    public long removeZeros(long n) {
        StringBuilder str = new StringBuilder();
        while(n!=0){
            long r = n % 10;
            if(r == 0){
                n = n / 10;
                continue;
            }
            str.append(r);
            n = n / 10;
        }
        long num = Long.parseLong(str.reverse().toString());
        return num;
    }
}