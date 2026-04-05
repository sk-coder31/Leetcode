class Solution {
    public boolean judgeCircle(String moves) {
        int[] drow = new int[]{-1,1,0,0};
        int[] dcol = new int[]{0,0,-1,1};//udlr
        int[] res = new int[]{0,0};
        for(int i = 0 ; i < moves.length() ; i++){
            int row = res[0];
            int col = res[1];
            if(moves.charAt(i)=='U'){
                row += drow[0];
                col += dcol[0];
            }else if(moves.charAt(i)=='D'){
                row += drow[1];
                col += dcol[1];
            }else if(moves.charAt(i)=='L'){
                row += drow[2];
                col += dcol[2];
            }else{
                row += drow[3];
                col += dcol[3];
            }
            res[0] = row;
            res[1] = col;
        }
        if(res[0]==0 && res[1]==0){
            return true;
        }
        return false;

        
    }
}