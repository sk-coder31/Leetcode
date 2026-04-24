class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        List<List<Integer>>arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 1){
                    arr.get(i).add(j);
                }
            }
        }
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++){
            res[i] = arr.get(i).size();
        }
        return res;
    }
}