class Solution {
    public int[][] reverseSubmatrix(int[][] arr, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            for (int j = 0; j < k; j++) {
                int temp = arr[x + i][y + j];
                arr[x + i][y + j] = arr[x + k - 1 - i][y + j];
                arr[x + k - 1 - i][y + j] = temp;
            }
        }
        return arr;
    }
}
