class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<int[]>st = new Stack<>();
        int[] res = new int[n];
        for(int i = 0 ; i < heights.length; i++){
            while(!st.isEmpty() && st.peek()[0]<heights[i]){
                int idx = st.peek()[1];
                res[idx]++;
                st.pop();
            }
            if(!st.isEmpty() && st.peek()[0]>heights[i]){
                int idx = st.peek()[1];
                res[idx]++;
            }
            st.add(new int[]{heights[i],i});
        }
        return res;
    }
}