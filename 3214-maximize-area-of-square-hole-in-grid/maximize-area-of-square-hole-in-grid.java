class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int count1 = 1;
        int count2 = 1;

        int max1 = 0;
        for(int i = 1 ; i < hBars.length ; i++){
            if(hBars[i]-hBars[i-1]==1){
                count1++;
            }else{
                max1 = Math.max(max1,count1);
                count1 = 1;
            }
        }
        max1 = Math.max(max1,count1);
        int max2 = 0;
        for(int i = 1 ; i < vBars.length ; i++){
            if(vBars[i]-vBars[i-1]==1){
                count2++;
            }else{
                max2 = Math.max(max2,count2);
                count2 = 1;
            }
        }
        max2 = Math.max(max2,count2);
        
        int s = Math.min(max1,max2)+1;
        return s*s;
    }
}