class Solution {
    int f;
    List<Integer> res;
    int maxi;
    Map<String, Boolean> memo;

    public int[] minDifference(int n, int k) {
        this.f = n;
        this.maxi = Integer.MAX_VALUE;
        this.res = new ArrayList<>();
        this.memo = new HashMap<>();

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                arr.add(i);
            }
        }

        dfs(0, 1, k, new ArrayList<>(), arr);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int idx, int prod, int size, List<Integer> path, List<Integer> divs) {
        if (size == 0) {
            if (prod == f) {
                int min = Collections.min(path);
                int max = Collections.max(path);
                if (max - min < maxi) {
                    maxi = max - min;
                    res = new ArrayList<>(path);
                }
            }
            return;
        }

        if (idx == divs.size() || prod > f) return;

        String key = idx + "," + prod + "," + size;
        if (memo.containsKey(key)) return;
        memo.put(key, true);

        dfs(idx + 1, prod, size, path, divs);

        path.add(divs.get(idx));
        dfs(idx + 1, prod * divs.get(idx), size - 1, path, divs);
        path.remove(path.size() - 1);

        path.add(divs.get(idx));
        dfs(idx, prod * divs.get(idx), size - 1, path, divs);
        path.remove(path.size() - 1);
    }
}
