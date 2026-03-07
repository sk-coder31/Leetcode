class Solution {
    public int minFlips(String s) {
        int size = s.length();
        int i = 0;
        int j = 0;
        int res1 = 0;
        int res2 = 0;
        int min = Integer.MAX_VALUE;
        char ch1 = '0';
        char ch2 = '0';
        while(j<2*size){
            if(j % 2 == 0){
                ch1 = '0';
                ch2 = '1';
            }else{
                ch1 = '1';
                ch2 = '0';
            }


            if(s.charAt(j%size)!=ch1){
                res1++;
            }
            if(s.charAt(j%size)!=ch2){
                res2++;
            }
            if(j - i + 1 > size){
                char x , y;
                if(i % 2 == 0){
                    x = '0';
                    y = '1';
                }else{
                    x = '1';
                    y = '0';
                }
                if(s.charAt(i%size)!=x){
                    res1--;
                }
                if(s.charAt(i%size)!=y){
                    res2--;
                }
                i++;
            }
            if(j - i + 1 == size){
                min = Math.min(min,Math.min(res1,res2));
            }
            j++;
        }
        return min;
    }
}