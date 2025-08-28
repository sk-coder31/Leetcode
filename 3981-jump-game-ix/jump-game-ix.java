class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        Disjoint dis = new Disjoint(n);
        for (int i = 0; i < n; i++) {
            int prev = i;
            if (!st.isEmpty()) {
                prev = st.peek();
            }
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                dis.union(st.pop(), i);
            }
            if (nums[i] > nums[prev]) {
                st.push(i);
            } else {
                st.push(prev);
            }
        }
        st.clear();
        for (int i = n-1; i >=0; i--) {
            int prev = i;
            if (!st.isEmpty()) {
                prev = st.peek();
            }
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                dis.union(st.pop(), i);
            }
            if (nums[i] < nums[prev]) {
                st.push(i);
            } else {
                st.push(prev);
            }
        }
        System.out.println(Arrays.toString(dis.parent));
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dis.findPar(i);
            mp.put(root, Math.max(mp.getOrDefault(root, Integer.MIN_VALUE), nums[i]));
        }
        for (int i = 0; i < n; i++) {
            nums[i] = mp.get(dis.findPar(i));
        }
        return nums;
    }
}

class Disjoint {
    int n;
    int[] parent;
    int[] rank;

    Disjoint(int n) {
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findPar(int n) {
        if (parent[n] == n) { 
            return n;
        }
        return parent[n] = findPar(parent[n]); 
    }

    public void union(int x, int y) {
        x = findPar(x);
        y = findPar(y);
        if (x == y) {
            return;
        }
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[y] < rank[x]) {
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
}