class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = arr[i];
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' ||
            ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                int val = (int)ch;
                pq.add(val);
            }
        }
        for(int i = 0 ; i < s.length() ; i++){
            char ch = arr[i];
            if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' ||
            ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                char sh = (char)(int)pq.poll();
                arr[i] = sh;
            }
        }
        return new String(arr);
    }
}