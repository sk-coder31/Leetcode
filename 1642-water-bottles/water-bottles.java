class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int count = total;
        
        while(total>=numExchange){
            int filled = total / numExchange;
            int unfilled = total - filled * numExchange;
            total = filled + unfilled;
            count += filled;
        }
        return count;
    }
}