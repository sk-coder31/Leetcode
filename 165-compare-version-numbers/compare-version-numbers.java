class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while(i < arr1.length && j < arr2.length){
            int n = Integer.parseInt(arr1[i]);
            int m = Integer.parseInt(arr2[i]);
            int cmp = Integer.compare(n,m);
            if(cmp == 0){
                i++;
                j++;
            }else{
                return cmp;
            }
        }
        while(i < arr1.length){
            int x = Integer.parseInt(arr1[i]);
            if(x<=0){
                i++;
                continue;
            }else{
                return 1;
            }
            
        }
        while(j < arr2.length){
            int x = Integer.parseInt(arr2[j]);
            if(x<=0){
                j++;
                continue;
            }else{
                return -1;
            }
            
        }
        return 0;
    }
}