class Solution {
    public String maximumXor(String s, String t) {
        int[] arr = new int[2];
        for(int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            int idx = ch - '0';
            arr[idx]++;
        }
        StringBuilder sc = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '0'){
                if(arr[1]>=1){
                    sc.append(1);
                    arr[1]--;
                }else{
                    sc.append(0);
                    arr[0]--;
                }
            }else{
                if(arr[0]>=1){
                    sc.append(1);
                    arr[0]--;
                }else{
                    sc.append(0);
                    arr[1]--;
                }
            }
        }
        
        return sc.toString();
    }
}