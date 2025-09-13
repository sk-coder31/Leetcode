class Solution {
    public int[][] generateSchedule(int n) {
        if (n < 5) {
            return new int[][] {};
        }

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    arr.add(Arrays.asList(i, j));
                }
            }
        }

        Random rand = new Random();
        List<List<Integer>> ans = null;

        for (int retry = 0; retry < 10; retry++) {
            Collections.shuffle(arr, rand);
            boolean valid = true;

            for (int i = 1; i < arr.size(); i++) {
                if (conflict(arr.get(i - 1), arr.get(i))) {
                    boolean swapped = false;

                    for (int j = i + 1; j < arr.size(); j++) {
                        if (conflict(arr.get(i - 1), arr.get(j)) == false) {
                            swap(i, j, arr);
                            swapped = true;
                            break;
                        }
                    }

                    if (swapped == false) {
                        valid = false;
                        break; 
                    }
                }
            }

            if (valid == true) {
                ans = new ArrayList<>(arr); 
                break;
            }
        }
        if (ans == null) {
            return new int[][] {}; 
        }

        int[][] res = new int[ans.size()][2];
        for (int k = 0; k < ans.size(); k++) {
            res[k][0] = ans.get(k).get(0);
            res[k][1] = ans.get(k).get(1);
        }
        return res;
    }

    private boolean conflict(List<Integer> a, List<Integer> b) {
        return (a.get(0).equals(b.get(0)) || 
                a.get(0).equals(b.get(1)) || 
                a.get(1).equals(b.get(0)) || 
                a.get(1).equals(b.get(1)));
    }

    private void swap(int i, int j, List<List<Integer>> arr) {
        List<Integer> temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
