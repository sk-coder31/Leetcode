class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        int n = intervals.length;
        List<int[]>ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int[] curr = intervals[i];
            int start = curr[0];
            int end = curr[1];

            int j = i + 1;
            while(j < n && end>=intervals[j][0]){
                end = Math.max(end,intervals[j][1]);
                j++;
            }
            ans.add(new int[]{start,end});
            i = j-1;
        }
        int[][] res = new int[ans.size()][2];
        for(int i = 0 ; i < ans.size() ; i++){
            res[i] = ans.get(i);
        }
        return res;

    }
}