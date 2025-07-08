class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n+1];
        fact[0] = 1;
        List<Integer>numbers = new ArrayList<>();
        for(int i = 1; i < n ; i++){
            fact[i] = fact[i-1] * i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder sc = new StringBuilder();
        k = k - 1;
        int j = n-1;
        while(true){
            sc.append(numbers.get(k/fact[j]));
            numbers.remove(k/fact[j]);
            if(numbers.size()==0){
                break;
            }
            k = k % fact[j];
            j--;
        }
        return sc.toString();
    }
}