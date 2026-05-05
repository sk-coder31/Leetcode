class CustomStack {
    List<Integer> st;
    int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.st = new ArrayList<>();
    }

    public void push(int x) {
        if (st.size() < maxSize) {
            st.add(x);
        }
    }

    public int pop() {
        if (st.size() == 0) return -1;

        return st.remove(st.size() - 1);
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, st.size());

        for (int i = 0; i < limit; i++) {
            st.set(i, st.get(i) + val);
        }
    }
}