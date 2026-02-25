class Solution {
    public List<String> subdomainVisits(String[] arr) {
        List<String>res = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            String[] splited = str.split(" ");
            int last_dot = -1;
            int val = Integer.parseInt(splited[0]) + hm.getOrDefault(splited[1], 0);
            hm.put(splited[1], val);

            for (int j = 0; j < splited[1].length(); j++) {
                if (splited[1].charAt(j) == '.') {
                    String a = splited[1].substring(j + 1);
                    // System.out.println(a);
                    val = Integer.parseInt(splited[0]) + hm.getOrDefault(a, 0);
                    hm.put(a, val);
                }
            }
        }
        for(String key : hm.keySet()){
            int val = hm.get(key);
            String add = Integer.toString(val)+" "+key;
            res.add(add);
        }
        return res;
    }
}