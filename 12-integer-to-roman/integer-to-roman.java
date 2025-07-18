class Solution {
    public String intToRoman(int num) {
        int[] numlist = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] list = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String str = "";
        while(num > 0 ){
            for(int i = 0 ; i < numlist.length ; i++){
                if(num>=numlist[i]){
                    int times = num/numlist[i];
                    str += list[i].repeat(times);
                    num = num % numlist[i];
                    
                }
            }
            
        }
        return str;
    }
}