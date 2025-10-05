class Pair {
    int row, col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] visited1 = new boolean[n][m]; 
        boolean[][] visited2 = new boolean[n][m]; 

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            q.add(new Pair(0, i));
            visited1[0][i] = true;
        }
        for (int i = 1; i < n; i++) {
            q.add(new Pair(i, 0));
            visited1[i][0] = true;
        }
        bfs(q, visited1, heights, drow, dcol, n, m);

        q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            q.add(new Pair(n - 1, i));
            visited2[n - 1][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            q.add(new Pair(i, m - 1));
            visited2[i][m - 1] = true;
        }
        bfs(q, visited2, heights, drow, dcol, n, m);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited1[i][j] && visited2[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<Pair> q, boolean[][] visited, int[][] heights,
                     int[] drow, int[] dcol, int n, int m) {
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int delrow = p.row + drow[i];
                int delcol = p.col + dcol[i];
                if (delrow >= 0 && delcol >= 0 && delrow < n && delcol < m &&
                    !visited[delrow][delcol] &&
                    heights[p.row][p.col] <= heights[delrow][delcol]) {

                    visited[delrow][delcol] = true;
                    q.add(new Pair(delrow, delcol));
                }
            }
        }
    }
}
