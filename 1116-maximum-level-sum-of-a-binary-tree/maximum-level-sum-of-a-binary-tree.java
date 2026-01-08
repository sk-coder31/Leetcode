class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int max_level = 0;
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0; i < size ; i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(sum > max){
                max = sum;
                max_level = level;
            }
            level++;
        }
        return max_level;
    }
}