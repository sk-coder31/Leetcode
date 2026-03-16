class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                set.add(grid[r][c]);
                int k = 1;
                while (k <= 100) {
                    if (check(r, c, k, n, m)) {
                        int sum = 0;
                        for (int i = 0; i < k; i++)
                            sum += grid[r - k + i][c + i];
                        for (int i = 0; i < k; i++)
                            sum += grid[r + i][c + k - i];
                        for (int i = 0; i < k; i++)
                            sum += grid[r + k - i][c - i];
                        for (int i = 0; i < k; i++)
                            sum += grid[r - i][c - k + i];

                        set.add(sum);
                    }
                    k++; 
                }
            }
        }
        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int i = 0;
        for (int val : set) {  
            if (i == size)
                break;
            ans[i++] = val;
        }

        return ans;
    }

    public boolean check(int r, int c, int k, int n, int m) {
        if (r - k >= 0 && r - k < m &&  
            r + k >= 0 && r + k < m &&
            c - k >= 0 && c - k < n &&
            c + k >= 0 && c + k < n) {
            return true;
        }
        return false;
    }
}