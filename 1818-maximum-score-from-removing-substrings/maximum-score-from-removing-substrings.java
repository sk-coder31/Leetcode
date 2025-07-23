class Solution {
    int[] arr = new int[]{0,0};
    public int maximumGain(String s, int x, int y) {
        if(x>=y){
            String str = remove(s,'a','b',x,0);
            remove(str,'b','a',y,1);
        }else if(y>x){
            String str = remove(s,'b','a',y,0);
            remove(str,'a','b',x,1);
        }
        return arr[0]+arr[1];
    }
    public String remove(String str , char a , char b,int x,int idx){
        int count = 0;
        Stack<Character>st = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++){
            if(!st.isEmpty() && st.peek()==a && str.charAt(i)==b){
                count += x;
                st.pop();
            }else{
                st.push(str.charAt(i));
            }
        }
        arr[idx] = count;
        StringBuilder sc = new StringBuilder();
        while(!st.isEmpty()){
            sc.insert(0,st.pop());
        }
        return sc.toString();
    }
}