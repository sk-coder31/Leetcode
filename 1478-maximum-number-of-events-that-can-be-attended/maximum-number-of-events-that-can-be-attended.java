class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int maxday = 0;
        for(int[] e : events){
            maxday = Math.max(e[1],maxday);
        }

        int day =events[0][0];
        int count = 0;
        int i = 0;
        while(day <= maxday){

            while(i < events.length && events[i][0]==day){
                pq.add(events[i][1]);
                i++;
            }

            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }
            day++;
        }
        return count;
    }
}