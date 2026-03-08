class Solution {
    HashSet<String>hs;
    public String findDifferentBinaryString(String[] nums) {
        hs = new HashSet<>();
        for(String i : nums){
            hs.add(i);
        }
        int size = nums.length;
        String str = helper("",size,hs);
        return str;
    }
    public String helper(String str,int n,HashSet<String>hs){
        if(n == 0){
            if(!hs.contains(str)){
                return str;
            }else{
                return "";
            }
        }

        String left = helper(str+"1",n-1,hs);
        String right = helper(str+"0",n-1,hs);

        if(left.length()>0)return left;
        if(right.length()>0)return right;
        return "";
    }
}