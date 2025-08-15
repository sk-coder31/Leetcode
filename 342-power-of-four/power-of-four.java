class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0 || n==2 || n==3){
            return false;
        }
        return dp(n);
    }
    public boolean dp(int n){
        if(n==1){
            return true;
        }
        if(n%4==0){
            boolean val = dp(n/4);
            if(val==true){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
}