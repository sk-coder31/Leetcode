class Solution {
    public boolean checkGoodInteger(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = 0;
        int temp = n;

        while (temp > 0) {
            int r = temp % 10;
            sum += r;
            temp /= 10;
        }

        temp = n;
        int sq_sum = 0;

        while (temp > 0) {
            int r = temp % 10;

            if (hm.containsKey(r)) {
                sq_sum += hm.get(r);
            } else {
                int square = r * r;
                sq_sum += square;
                hm.put(r, square);
            }

            temp /= 10;
        }

        return sq_sum - sum >= 50;
    }
}