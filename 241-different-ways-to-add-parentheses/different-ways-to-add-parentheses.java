class Solution {
    String str;
    public List<Integer> diffWaysToCompute(String expression) {
        this.str = expression;
        int i = 0;
        int j = expression.length() - 1;
        return dp(i, j, expression);
    }

    public List<Integer> dp(int i, int j, String str) {
        List<Integer> temp = new ArrayList<>();
        String sub = str.substring(i,j+1);
        if(sub.chars().allMatch(Character::isDigit)){
            temp.add(Integer.parseInt(sub));
            return temp;
        }
        for (int s = i; s <= j; s++) {
            char ch = str.charAt(s);
            if (ch == '*' || ch == '+' || ch == '-') {
                List<Integer> s1 = dp(i, s-1, str);
                List<Integer> s2 = dp(s + 1, j, str);
                for (int n1 : s1) {
                    for (int n2 : s2) {
                        if (ch == '*') {
                            temp.add(n1 * n2);
                        } else if (ch == '-') {
                            temp.add(n1 - n2);
                        } else if (ch == '+') {
                            temp.add(n1 + n2);
                        }
                    }
                }
            }

        }
        return temp;

    }
}