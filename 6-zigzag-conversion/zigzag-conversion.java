class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 ){
            return s;
        }
        StringBuilder arr[] = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows ; i++){
            arr[i] = new StringBuilder();
        }
        boolean dir = true;
        int rows = 0;
        for(char ch : s.toCharArray()){
            System.out.println(rows);
            arr[rows].append(ch);
            if(rows==numRows-1){
                dir=false;
            }else if(rows==0){
                dir = true;
            }
            if(dir==true){
                rows++;
            }else{
                rows--;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < numRows ; i++){
            res.append(arr[i]);
        }
        return res.toString();
    }
}