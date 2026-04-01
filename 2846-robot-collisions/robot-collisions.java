class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Object[]> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new Object[] { positions[i], healths[i], directions.charAt(i), i });
        }

        Collections.sort(arr, (a, b) -> Integer.compare((int) a[0], (int) b[0]));

        Stack<Object[]> st = new Stack<>();

        for (int k = 0; k < n; k++) {
            Object[] curr = arr.get(k);
            int pos = (int) curr[0];
            int health = (int) curr[1];
            char dir = (char) curr[2];
            int idx = (int) curr[3];
            while (!st.isEmpty() && (char) st.peek()[2] == 'R' && dir == 'L') {
                int prevHealth = (int) st.peek()[1];

                if (prevHealth == health) {
                    st.pop();
                    health = 0;
                    break;
                } else if (prevHealth > health) {
                    st.peek()[1] = prevHealth - 1;
                    health = 0;
                    break;
                } else {
                    st.pop();
                    health -= 1;
                }
            }

            if (health > 0) {
                st.push(new Object[] { pos, health, dir, idx });
            }
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        while (!st.isEmpty()) {
            Object[] curr = st.pop();
            int health = (int) curr[1];
            int idx = (int) curr[3];
            map.put(idx, health);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;

    }
}