class Solution {
    public long flowerGame(int n, int m) {
        long count_odd_1 = 0;
        long count_even_1 = 0;
        if(n%2==0){
            count_odd_1 = n/2;
            count_even_1  = n/2;
        }else{
            count_even_1 = n/2;
            count_odd_1 = n-n/2;
        }
        long count_odd_2 = 0;
        long count_even_2 = 0;
        if(m%2==0){
            count_odd_2 = m/2;
            count_even_2  = m/2;
        }else{
            count_even_2 = m/2;
            count_odd_2= m-m/2;
        }
        return count_even_1 * count_odd_2 + count_odd_1 * count_even_2;
        
    }
}