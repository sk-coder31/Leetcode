class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        while(i<j){
            int width = j - i;
            int heigh = Math.min(height[i],height[j]);
            //System.out.println(height[i]+" "+height[j]+" "+width+" "+heigh+" "+heigh*width);
            max = Math.max(width*heigh,max);
            if(height[i] < height[j]){
                i++;
            }
            else if(height[j] <= height[i]){
                j--;
            }
        }
        return max;

    }
}