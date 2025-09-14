class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String,Integer>caseMap = new HashMap<>();
        HashMap<String,Integer>hm = new HashMap<>();
        Set<String>hs = new HashSet<>();
        for(int i = 0 ; i < wordlist.length ; i++){
            hs.add(wordlist[i]);

            caseMap.putIfAbsent(wordlist[i].toLowerCase(),i);

            StringBuilder sc = new StringBuilder();
            for(char ch : wordlist[i].toLowerCase().toCharArray()){
                if(ok(ch)){
                    sc.append("?");
                }else{
                    sc.append(ch);
                }
            }
            hm.putIfAbsent(sc.toString(),i);
        }

        String[] ans = new String[queries.length];
        int idx = 0;
        for(int i = 0 ; i < queries.length ; i++){
            String str = queries[i];

            if(hs.contains(str)){
                ans[i] = str;
                continue;
            }

            String lwr = str.toLowerCase();
            if(caseMap.containsKey(lwr)){
                ans[i] = wordlist[caseMap.get(lwr)];
                continue;
            }

            StringBuilder sc = new StringBuilder();

            for(char ch : lwr.toCharArray()){
                if(ok(ch)){
                    sc.append("?");
                }else{
                    sc.append(ch);
                }
            }

            String key = sc.toString();
            if(hm.containsKey(key)){

                //System.out.println("hi"+" "+key);
                ans[i] = wordlist[hm.get(key)];
                continue;
            }

            if(ans[i]==null){
                ans[i] = "";
                continue;
            }
        }
        return ans;
    }
    public boolean ok(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}