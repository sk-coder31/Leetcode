class MyCalendarTwo {
    TreeMap<Integer, Integer> hm;

    public MyCalendarTwo() {
        hm = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        hm.put(startTime, hm.getOrDefault(startTime, 0) + 1);
        hm.put(endTime, hm.getOrDefault(endTime, 0) - 1);
        int sum = 0;
        for (int keys : hm.keySet()) {
            sum += hm.get(keys);
            if (sum > 2) {
                hm.put(startTime, hm.getOrDefault(startTime, 0) - 1);
                hm.put(endTime, hm.getOrDefault(endTime, 0) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */