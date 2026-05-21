class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String>hs1 = new HashSet<>();
        HashSet<String>hs2 = new HashSet<>();
        for(int i = 0 ; i < arr1.length ; i++){
            int n = arr1[i];
            String str = Integer.toString(n);
            prefix(str,hs1);
        }
        for(int i = 0 ; i < arr2.length ; i++){
            int n = arr2[i];
            String str = Integer.toString(n);
            prefix(str,hs2);
        }
        int max = 0;
        for(String i : hs1){
            if(hs2.contains(i)){
                max = Math.max(i.length(),max);
            }
        }
        return max;
    }
    public void prefix(String str,HashSet<String>hs){
        for(int i = 0 ; i < str.length() ; i++){
            String sub = str.substring(0,i+1);
            hs.add(sub);
        }
        // System.out.println(hs);
    }
}