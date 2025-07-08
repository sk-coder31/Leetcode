class NumMatrix {
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        prefix = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(j==0){
                    prefix[i][j] = matrix[i][j];
                }else{
                    prefix[i][j] = prefix[i][j-1] + matrix[i][j];
                }
            }
        }
        // a a+b a+b+c
        // b b+c b+c+d
        // c c+d c+d+e

        for(int j = 0 ; j < m ; j++){
            for(int i = 1 ; i < n ; i++){
                prefix[i][j] = prefix[i-1][j]+prefix[i][j];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total_sum = prefix[row2][col2];

        if(row1>0){
            total_sum -= prefix[row1-1][col2];
        }
        if(col1>0){
            total_sum -= prefix[row2][col1-1];
        }
        if(row1>0 && col1>0){
            total_sum += prefix[row1-1][col1-1];
        }
        return total_sum;
    }
}

