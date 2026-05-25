class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int farthest = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            int start = Math.max(curr + minJump, farthest);
            int end = Math.min(curr + maxJump, s.length() - 1);

            for (int next = start; next <= end; next++) {
                if (s.charAt(next) == '0') {
                    if (next == s.length() - 1) return true;
                    q.offer(next);
                }
            }

            farthest = curr + maxJump + 1;
        }

        return s.length() == 1;
    }
}