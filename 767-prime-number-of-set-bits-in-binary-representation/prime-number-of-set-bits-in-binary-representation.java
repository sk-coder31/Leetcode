class Solution {
    public int countPrimeSetBits(int left, int right) {
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17 ,19));
        int count = 0;
        for(int i = left ; i <= right ; i++){
            int n = Integer.bitCount(i);
            if(hs.contains(n)){
                count++;
            }
        }
        return count;
    }
    
}