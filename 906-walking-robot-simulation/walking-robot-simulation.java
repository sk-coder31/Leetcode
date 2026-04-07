class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> hs = new HashSet<>();
        for (int[] i : obstacles) {
            int x = i[0];
            int y = i[1];
            String key = x + "#" + y; 
            hs.add(key);
        }

        Curr_Dir curr = new Curr_Dir(new int[] { 0, 0 }, 'N');
        int i = 0;
        int max = 0;
        int n = commands.length;

        while (i < n) {
            int step = commands[i];
            if (step == -1) {
                char dir = curr.dir;
                if (dir == 'N') curr.setDir('E');
                else if (dir == 'E') curr.setDir('S');
                else if (dir == 'S') curr.setDir('W');
                else curr.setDir('N');

            } else if (step == -2) {
                char dir = curr.dir;
                if (dir == 'N') curr.setDir('W');
                else if (dir == 'W') curr.setDir('S');
                else if (dir == 'S') curr.setDir('E');
                else curr.setDir('N');

            } else {
                for (int j = 1; j <= step; j++) {
                    int x = curr.curr[0];
                    int y = curr.curr[1];
                    char dir = curr.dir;

                    if (dir == 'N') {
                        String key = x + "#" + (y + 1);
                        if (hs.contains(key)) break; 
                        curr.setCurr(new int[] { x, y + 1 });

                    } else if (dir == 'S') {
                        String key = x + "#" + (y - 1);
                        if (hs.contains(key)) break;
                        curr.setCurr(new int[] { x, y - 1 });

                    } else if (dir == 'W') {
                        String key = (x - 1) + "#" + y;
                        if (hs.contains(key)) break;
                        curr.setCurr(new int[] { x - 1, y });

                    } else if (dir == 'E') {
                        String key = (x + 1) + "#" + y;
                        if (hs.contains(key)) break;
                        curr.setCurr(new int[] { x + 1, y });
                    }

                    int val = helper(curr);
                    max = Math.max(max, val);
                }
            }
            i++;
        }
        return max;
    }

    public int helper(Curr_Dir curr) {
        return curr.curr[0] * curr.curr[0] + curr.curr[1] * curr.curr[1];
    }
}

class Curr_Dir {
    int[] curr;
    char dir;

    Curr_Dir(int[] curr, char dir) {
        this.curr = curr;
        this.dir = dir;
    }

    public void setCurr(int[] curr) {
        this.curr[0] = curr[0];
        this.curr[1] = curr[1];
    }

    public void setDir(char dir) {
        this.dir = dir;
    }
}