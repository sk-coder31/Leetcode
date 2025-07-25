class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
                                     int[] student_id, int k) {

        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : positive_feedback) {
            hm.put(word, 3);
        }
        for (String word : negative_feedback) {
            hm.put(word, -1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; 
            return b[0] - a[0]; 
        });

        for (int i = 0; i < student_id.length; i++) {
            int id = student_id[i];
            String[] words = report[i].split(" ");
            int score = 0;

            for (String word : words) {
                score += hm.getOrDefault(word, 0);
            }

            pq.offer(new int[]{score, id});
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result.add(pq.poll()[1]);
        }
        return result;
    }
}
