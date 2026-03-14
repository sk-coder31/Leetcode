class Solution {
    List<String>list = new ArrayList<>();
    public String getHappyString(int n, int k) {
        int index = 0;
        HashSet<Character>used = new HashSet<>();
        helper(index,used,n,"");
        if(k>list.size()){
            return "";
        }
        return list.get(k-1);
    }
    public void helper(int index,HashSet<Character>used,int size,String str){
        if(str.length()==size){
            list.add(str);
            return;
        }
        for(char i = 'a';i<='c';i++){
            if(str.length()==0 || str.charAt(index-1)!=i){
                used.add(i);
                helper(index+1,used,size,str+i);
                used.remove(i);
            }
        }
        return;
    }
}