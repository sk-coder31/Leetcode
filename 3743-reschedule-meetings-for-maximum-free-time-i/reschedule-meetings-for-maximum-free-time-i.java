class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int start = 0;
        int n = startTime.length;
        List<Integer> arr = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            int free = startTime[i] - start;
            arr.add(free);
            start = endTime[i];
        }
        arr.add(eventTime - endTime[endTime.length-1]);

        int j = 0;
        int i = 0;
        int total = 0;
        int max = 0;
        while(j < arr.size()){
            max += arr.get(j);

            while(j-i+1>k+1){
                max -= arr.get(i);
                i++;
            }

            total =Math.max(total,max);
            j++;
        }
        return total;
       
        
    }
}
