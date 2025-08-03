class Solution {
    HashSet<String> hs = new HashSet<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair>> hm = new HashMap<>();
        int k = 0;
        for (List<String> i : equations) {
            double val = values[k];
            hm.putIfAbsent(i.get(0), new ArrayList<>());
            hm.putIfAbsent(i.get(1), new ArrayList<>());
            hm.get(i.get(0)).add(new Pair(i.get(1), val));
            hm.get(i.get(1)).add(new Pair(i.get(0), 1.0 / val));
            k++;
        }
        double[] arr = new double[queries.size()];
        int idx = 0;
        for (List<String> q : queries) {
            String src = q.get(0);
            String des = q.get(1);
            hs.clear();
            if(hm.containsKey(src) && hm.containsKey(des)){
                double val = dfs(src, des, hm);
            arr[idx] = val;
            }else{
                arr[idx] = -1.0;
            }
            
            idx++;
        }
        return arr;
    }

    public double dfs(String node,String target,HashMap<String, List<Pair>> hm){
        if(node.equals(target)){
            return 1.0;
        }
        if(!hm.containsKey(node) || !hm.containsKey(target)){
            return -1.0;
        }
        hs.add(node);
        for(Pair p: hm.get(node)){
            String key = p.key;
            Double val = p.val;
            if(!hs.contains(key)){
                double ans = dfs(key,target,hm);
                if(ans!=-1.0){
                    return ans*val;
                }
            }
            
        }
        return -1.0;
    }
}

class Pair {
    String key;
    Double val;

    Pair(String key, Double val) {
        this.key = key;
        this.val = val;
    }
}