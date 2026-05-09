class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        int layers = Math.min(n, m) / 2;

        for (int a = 0; a < layers; a++) {

            int top = a;
            int left = a;
            int bottom = n - 1 - a;
            int right = m - 1 - a;

            List<Integer> arr = new ArrayList<>();
            for (int j = left; j <= right; j++) {
                arr.add(grid[top][j]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                arr.add(grid[i][right]);
            }
            for (int j = right - 1; j >= left; j--) {
                arr.add(grid[bottom][j]);
            }
            for (int i = bottom - 1; i > top; i--) {
                arr.add(grid[i][left]);
            }

            int rot = k % arr.size();
            Collections.rotate(arr, -rot);
            int t = 0;
            for (int j = left; j <= right; j++) {
                grid[top][j] = arr.get(t++);
            }
            for (int i = top + 1; i <= bottom; i++) {
                grid[i][right] = arr.get(t++);
            }
            for (int j = right - 1; j >= left; j--) {
                grid[bottom][j] = arr.get(t++);
            }
            for (int i = bottom - 1; i > top; i--) {
                grid[i][left] = arr.get(t++);
            }
        }

        return grid;
    }
}