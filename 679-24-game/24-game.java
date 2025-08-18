class Solution {
    private static final double EPSILON = 1e-6;
    public boolean judgePoint24(int[] cards) {
        List<Double> result = new ArrayList<>();
        for (int c : cards) {
            result.add((double) c);
        }
        return dfs(result);
    }

    private boolean dfs(List<Double> result) {
        if (result.size() == 1) {
            return Math.abs(result.get(0) - 24) < EPSILON;
        }

        int n = result.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double num1 = result.get(i);
                double num2 = result.get(j);

                List<Double> next = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next.add(result.get(k));
                }
                double[] candidates = {
                    num1 + num2,
                    num1 - num2,
                    num2 - num1,
                    num1 * num2
                };

                for (double val : candidates) {
                    next.add(val);
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1);
                }

                if (Math.abs(num2) > EPSILON) {
                    next.add(num1 / num2);
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1);
                }
                if (Math.abs(num1) > EPSILON) {
                    next.add(num2 / num1);
                    if (dfs(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}
