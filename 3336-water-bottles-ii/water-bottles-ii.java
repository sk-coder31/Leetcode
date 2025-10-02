class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total_drank = 0;
        while(numBottles >= numExchange){
            total_drank += numExchange;
            numBottles = numBottles - numExchange;
            numBottles++;
            numExchange++;
        }
        return total_drank+numBottles;
    }
}