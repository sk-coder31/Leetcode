class MyCalendar {
    TreeMap<Integer,Integer>hm;
    public MyCalendar() {
        hm = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        hm.put(startTime,hm.getOrDefault(startTime,0)+1);
        hm.put(endTime,hm.getOrDefault(endTime,0)-1);
        int sum = 0;
        for(int key : hm.keySet()){
            sum += hm.get(key);
            if(sum>1){
                hm.put(startTime,hm.getOrDefault(startTime,0)-1);
                hm.put(endTime,hm.getOrDefault(endTime,0)+1);
                return false;
            }
        }
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */