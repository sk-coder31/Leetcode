class Solution {
    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] memo = new int[r][c];
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                memo[i][j] = -1;
            }
        }
        int sum = 0;
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(matrix[i][j]==1){
                    sum += dp(i,j,matrix,memo);
                }
            }
        }
        return sum ;

    }
    public int dp(int row,int col,int[][] matrix,int[][] memo){
        if(row >= memo.length || col >=memo[0].length || row<0 || col<0 || matrix[row][col]==0){
            return 0;
        }
        if(memo[row][col]!=-1){
            return memo[row][col];
        }
        
        int right = dp(row,col+1,matrix,memo);
        int down = dp(row+1,col,matrix,memo);
        int diag = dp(row+1,col+1,matrix,memo);

        return memo[row][col] = 1 + Math.min(right,Math.min(down,diag));
    }
}