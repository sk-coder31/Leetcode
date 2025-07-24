class Solution {
    public String robotWithString(String s) {
        char[] arr = new char[s.length()];
        arr[s.length()-1] = s.charAt(s.length()-1);
        for(int i = s.length()-2; i>=0 ; i--){
            arr[i] = (char)Math.min(arr[i+1], s.charAt(i));

        }
        int n = s.length();
        StringBuilder str = new StringBuilder();
        Stack<Character>st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch>=arr[i]){
                st.push(ch);
            }
            while(!st.isEmpty() && (i == n - 1 || st.peek() <= arr[i + 1])){
                str.append(st.pop());
            }
        }
        // // 
        // while(!st.isEmpty()){
        // //     str.append(st.pop());
        // // }
        return str.toString();
    }
}