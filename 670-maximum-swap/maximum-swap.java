class Solution {
    public int maximumSwap(int num) {
        String t = Integer.toString(num);
        int n = t.length();
        int[] max_idx = new int[t.length()];
        char[] arr = t.toCharArray();
        max_idx[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[max_idx[i + 1]]) {
                max_idx[i] = i;
            } else {
                max_idx[i] = max_idx[i + 1];
            }
        }
        System.out.println(Arrays.toString(max_idx));
        for (int i = 0; i < n; i++) {
            int idx = max_idx[i];
            if (idx == i) {
                continue;
            } else {
                if(arr[idx]==arr[i]){
                    continue;
                }
                swap(idx, i, arr);
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }

    public void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}