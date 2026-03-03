class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            int count = 0;
            for(int j = n-1 ; j>=0 ; j--){
                if(grid[i][j]==1){
                    break;
                }else{
                    count++;
                }
            }
            arr[i] = count;
        }
        int steps= 0;
        for(int i = 0 ; i < arr.length ; i++){
            int need = n-i-1;
            int j = i;
            while(j < n && arr[j]<need){
                j++;
            }
            if(j == n){
                return -1;
            }
            steps += (j-i);
            while(j>i){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return steps;
    }
}