class Solution {
    public int minimumDeletions(String s) {
        Stack<Character>st = new Stack<>();
        int curr = s.length()-1;
        int count = 0;
        while(curr >= 0){
            if(!st.isEmpty() && s.charAt(curr)=='b' && st.peek()=='a'){
                st.pop();
                count++;
            }else{
                st.push(s.charAt(curr));
            }
            curr--;
        }
        return count;
    }
}