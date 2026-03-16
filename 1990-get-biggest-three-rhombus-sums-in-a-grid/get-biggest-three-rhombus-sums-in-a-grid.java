class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>((a,b)->b-a);

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                set.add(grid[r][c]);

                for(int k = 1; r+k < m && r-k >= 0 && c-k >= 0 && c+k < n; k++){

                    int sum = 0;
                    for(int i = 0; i < k; i++)
                        sum += grid[r-k+i][c+i];
                    for(int i = 0; i < k; i++)
                        sum += grid[r+i][c+k-i];
                    for(int i = 0; i < k; i++)
                        sum += grid[r+k-i][c-i];
                    for(int i = 0; i < k; i++)
                        sum += grid[r-i][c-k+i];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int i = 0;
        for(int val : set){
            if(i == size) break;
            ans[i++] = val;
        }

        return ans;
    }
}