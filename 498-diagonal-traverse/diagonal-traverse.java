class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] arr = new int[n * m];
        int idx = 0;
        boolean flag = true;
        for (int row = 0; row < n; row++) {
            ArrayList<Integer> ls = new ArrayList<>();
            int i = row;
            int j = 0;
            
            if (flag) {
                while (i >= 0 && i < n && j >= 0 && j < m) {
                    arr[idx++] = mat[i][j];
                    i--;
                    j++;
                }
            } else {
                while (i >= 0 && i < n && j >= 0 && j < m) {
                    ls.add(mat[i][j]);
                    i--;
                    j++;
                }
                for (int k = ls.size() - 1; k >= 0; k--) {
                    arr[idx++] = ls.get(k);
                }
            }
            flag = !flag;
        }

        for (int col = 1; col < m; col++) {
            ArrayList<Integer> ls = new ArrayList<>();
            int i = n - 1;
            int j = col;
            
            if (flag) {
                while (i >= 0 && i < n && j >= 0 && j < m) {
                    arr[idx++] = mat[i][j];
                    i--;
                    j++;
                }
            } else {

                while (i >= 0 && i < n && j >= 0 && j < m) {
                    ls.add(mat[i][j]);
                    i--;
                    j++;
                }
                for (int k = ls.size() - 1; k >= 0; k--) {
                    arr[idx++] = ls.get(k);
                }
            }
            flag = !flag;
        }
        
        return arr;
    }
}

