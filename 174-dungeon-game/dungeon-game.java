class Solution {
    int[][] memo ;
    public int calculateMinimumHP(int[][] dungeon) {
        int row = 0;
        int col = 0;
        int n = dungeon.length;
        int m = dungeon[0].length;
        memo = new int[n][m];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return dp(row,col,n,m,dungeon);
    }
    public int dp(int r,int c,int n,int m,int[][] dungeon){
        if(r==n-1 && c==m-1){
            if(dungeon[r][c]>=0){
                return 1;
            }else{
                return Math.abs(dungeon[r][c])+1;
            }
        }
        if(r<0 || c<0 || r>=n || c>=m){
            return Integer.MAX_VALUE;
        }
        if(memo[r][c]!=-1)return memo[r][c];
        int right = 0;
        int down = 0;
        right = dp(r,c+1,n,m,dungeon);
        down = dp(r+1,c,n,m,dungeon);

        int val = Math.min(right,down) - dungeon[r][c];
        return memo[r][c] =  Math.max(val,1);
        

    }
}