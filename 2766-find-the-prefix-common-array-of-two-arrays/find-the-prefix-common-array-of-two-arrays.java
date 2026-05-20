class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer>setA = new HashSet<>();
        Set<Integer>setB = new HashSet<>();
        int n = A.length;
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            int n1 = A[i];
            int n2 = B[i];
            setA.add(n1);
            setB.add(n2);
            HashSet<Integer> temp = new HashSet<>(setA);
            temp.retainAll(setB);
            ans[i] = temp.size();
        }
        return ans;
    }
}