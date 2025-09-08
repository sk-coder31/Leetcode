class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        long count = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty() && st.peek() - i >= 2) {
                count++;
            }
            st.push(i);
        }
        st.clear();
        // Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty() && i-st.peek() >= 2) {
                count++;
            }
            st.push(i);
        }

        return count;
    }
}