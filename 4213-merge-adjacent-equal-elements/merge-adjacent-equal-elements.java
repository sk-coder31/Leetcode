class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long>st = new Stack<>();
        for(int i = 0 ; i < nums.length; i++){
            long curr = nums[i];
            while(!st.isEmpty() && st.peek() == curr){
                curr = st.peek() + curr;
                st.pop();
            }
            st.push(curr);
        }
        System.out.println(st);
        List<Long>ls = new ArrayList<>();
        while(!st.isEmpty()){
            ls.add(st.pop());
        }
        Collections.reverse(ls);
        return ls;

    }
}
//[2]
//[2,1]
//[2,1,1]