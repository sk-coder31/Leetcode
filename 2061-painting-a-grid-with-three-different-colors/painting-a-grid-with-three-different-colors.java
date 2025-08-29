class Solution {
    List<String>list = new ArrayList<>();
    int mod = 1_000_000_007;
    int[][] memo;
    public int colorTheGrid(int m, int n) {
        char[] arr = new char[]{'r','g','b'};
        generate(m,arr,"");
        memo = new int[list.size()][n+1];
        for(int [] r : memo){
            Arrays.fill(r,-1);
        }
        int count = 0;
        for(int i = 0 ; i < list.size() ; i++){
            count = (count + dp(i,n-1))%mod;
        }
        return count;

    }
    public int dp(int prev_idx,int size){
        if(size==0){
            return 1;
        }
        if(memo[prev_idx][size]!=-1){
            return memo[prev_idx][size];
        }
        int count = 0;
        String str1 = list.get(prev_idx);
        for(int i = 0 ; i < list.size() ; i++){
            String str2 = list.get(i);
            if(i!=prev_idx && ok(str1,str2)){
                count = (count + dp(i,size-1))%mod;
            }
        }
        return memo[prev_idx][size] = count;
    }
    public void generate(int len,char[] arr,String str){
        if(len==0){
            list.add(str);
            return;
        }
        int size = str.length();
        for(int i = 0 ; i < arr.length ; i++){
            if(size==0 || str.charAt(size-1)!=arr[i]){
                generate(len-1,arr,str+arr[i]);
            }
        }
        return;
    }
    public boolean ok(String str1,String str2){
        for(int i = 0 ; i < str1.length() ; i++){
            if(str1.charAt(i)==str2.charAt(i)){
                return false;
            }
        }
        return true;
    }

}