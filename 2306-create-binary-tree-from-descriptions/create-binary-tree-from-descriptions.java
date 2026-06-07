class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int[] arr : descriptions) {
            int parent = arr[0];
            int child = arr[1];
            int isleft = arr[2];
            hm.putIfAbsent(parent, new TreeNode(parent));
            hm.putIfAbsent(child, new TreeNode(child));
            TreeNode p = hm.get(parent);
            TreeNode c = hm.get(child);
            if(isleft == 1){
                p.left = c;
            }else{
                p.right = c;
            }
            hs.add(child);
        }
        for(int i : hm.keySet()){
            if(!hs.contains(i)){
                return hm.get(i);
            }
        }
        return null;
    }
}