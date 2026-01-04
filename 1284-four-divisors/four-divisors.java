class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int n = nums[i];
            int count = 0;
            int sum = 0;
            for(int j = 1 ; j <= n ; j++){
                if(n % j == 0){
                    // System.out.println(j+" ");
                    count++;
                    sum += j;
                }
                if(count>4)break;
            }
            // System.out.println();
            if(count==4){
                total += sum;
            }
        }
        return total;
    }
}