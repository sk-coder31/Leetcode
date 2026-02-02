class Solution {
    public int countMonobit(int n) {
        int start = (int)Math.pow(2,1)-1;
        int incre = 1;
        int count = 1;
        while(start<=n){
            incre = incre+1;
            start = (int)Math.pow(2,incre)-1;
            count++;
        }
        return count;
    }
}