class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String>arr = new ArrayList<>();
        Queue<String>q = new LinkedList<>();
        Set<String>visited = new HashSet<>();
        boolean found = false;
        q.add(s);
        visited.add(s);
        while(!q.isEmpty()){
            String curr = q.poll();
            if(isValid(curr)){
                found = true;
                arr.add(curr);
            }
            if(found){
                continue;
            }
            for(int i = 0 ; i < curr.length() ; i++){
                if(curr.charAt(i)!='(' && curr.charAt(i)!=')'){
                    continue;
                }
                String next = curr.substring(0,i) + curr.substring(i+1);
                // System.out.println(next+" "+i);
                if(!visited.contains(next)){
                    q.add(next);
                    visited.add(next);
                }
            }
        }
        return arr;
    }
    boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}