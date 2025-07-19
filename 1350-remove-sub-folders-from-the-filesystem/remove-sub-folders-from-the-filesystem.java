class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        //System.out.println(folder);
        int n = folder.length;
        List<String>root = new ArrayList<>();
        for(int i = 0;i < n ; i++){
            String str = folder[i];//str2
            boolean flag = true;
            for(String base : root){
                if(str.startsWith(base+"/")){
                    flag = false;
                    continue;
                }
            }
            if(flag)
            root.add(str);
        }
        return root;
    }
}