class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>hs = new HashSet<>();
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                char ch = board[i][j];
                if(ch=='.'){
                    continue;
                }
                int i_ = i/3;
                int j_ = j/3;
                String str1 = ch+"in row"+i;
                String str2 = ch+"in col"+j;
                String both = ch+"in both"+i_+"and"+j_;
                if(hs.contains(str1) || hs.contains(str2) || hs.contains(both)){
                    return false;
                }
                hs.add(str1);
                hs.add(str2);
                hs.add(both);
            }
        }
        return true;
    }
}