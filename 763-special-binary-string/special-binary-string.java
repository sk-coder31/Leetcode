class Solution {
    public String makeLargestSpecial(String s) {
        String res = helper(s);
        return res;
    }
    public String helper(String s){
        if(s.length() == 0){
            return "";
        }
        int start = 0;
        int count = 0;
        List<String>all = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i)=='1'){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                String mid = s.substring(start+1,i);
                String res = helper(mid);
                start = i+1;
                all.add("1"+res+"0");
            }
        }
        Collections.sort(all,Collections.reverseOrder());
        String ans = "";
        for(String i : all){
            ans += i;
        }
        return ans;
    }
}