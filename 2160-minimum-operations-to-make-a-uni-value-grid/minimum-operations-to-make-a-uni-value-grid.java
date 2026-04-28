class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer>res = new ArrayList<>();
        int check = grid[0][0];
        int v = helper(check,grid);
        if(v == 0){
            return 0;
        }
        v = grid[0][0] % x;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]%x == v){
                    res.add(grid[i][j]);
                    continue;
                }
                else{
                    return -1;
                }
            }
        }
        Collections.sort(res);
        int len = res.size();
        int val = res.get(len/2);
        int count = 0;
        for(int i : res){
        count += Math.abs((i-val)/x);
        }
        return count;
    }
    public int helper(int x,int[][] grid){
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(x != grid[i][j]){
                    return 10;
                }
            }
        }
        return 0;
    }
}