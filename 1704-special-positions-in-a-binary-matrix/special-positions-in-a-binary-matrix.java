class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int specialCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    boolean isSpecialRow = checkRow(i, mat);
                    boolean isSpecialCol = checkCol(j, mat);
                    if (isSpecialRow && isSpecialCol) {
                        specialCount++;
                    }
                }
            }
        }
        return specialCount;
    }

    public boolean checkRow(int i, int[][] mat) {
        int count = 0;
        for (int j = 0; j < mat[i].length; j++) {
            if (mat[i][j] == 1) {
                count++;
            }
        }
        return count == 1;
    }

    public boolean checkCol(int j, int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][j] == 1) {
                count++;
            }
        }
        return count == 1;
    }
}
