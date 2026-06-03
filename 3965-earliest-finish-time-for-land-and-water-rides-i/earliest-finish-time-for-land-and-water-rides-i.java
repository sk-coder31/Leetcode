class Solution {
    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int landFinish =
                        landStartTime[i] + landDuration[i];

                int finish1 =
                        Math.max(landFinish, waterStartTime[j])
                        + waterDuration[j];

                ans = Math.min(ans, finish1);
                int waterFinish =
                        waterStartTime[j] + waterDuration[j];

                int finish2 =
                        Math.max(waterFinish, landStartTime[i])
                        + landDuration[i];

                ans = Math.min(ans, finish2);
            }
        }

        return ans;
    }
}