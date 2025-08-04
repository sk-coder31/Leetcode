class Solution {
    List<String>result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        dfs("",open,close,n);
        return result;
    }
    public void dfs(String str , int open,int close,int n){
        if(open==0 && close==0){
            result.add(str);
        }
        if(open>0){
            dfs(str+"(",open-1,close,n);
        }
        if(close>open){
            dfs(str+")",open,close-1,n);
        }
        return;
    }
}