class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[] drow = new int[] { -1, 1, 0, 0 };
        int[] dcol = new int[] { 0, 0, -1, 1 };
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[3] == b[3])
                        return b[2] - a[2];
                    return a[3] - b[3];
                });
        for (int[] arr : sources) {
            int r = arr[0];
            int c = arr[1];
            int val = arr[2];
            int time = 0;
            pq.add(new int[] { r, c, val, time });
        }
        boolean[][] visited = new boolean[n][m];
        int[][] grid = new int[n][m];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int color = curr[2];
            int time = curr[3];
            if (visited[r][c] == true) {
                continue;
            }
            visited[r][c] = true;
            grid[r][c] = color;
            for (int i = 0; i < 4; i++) {
                int delrow = r + drow[i];
                int delcol = c + dcol[i];
                if (delrow >= 0 && delcol >= 0 && delrow < n && delcol < m && !visited[delrow][delcol]) {
                    pq.add(new int[] { delrow, delcol, color, time + 1 });
                }
            }
        }
        return grid;
    }
}