class Solution {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(root.left == null && root.right == null){
            return 0;
        }
        if(root.left!= null && root.right!=null && root.val == root.left.val && root.val == root.right.val){
            ans = Math.max(ans,left+right+2);
            return 1+Math.max(left,right);
        }
        if(root.left != null && root.val == root.left.val){
            ans = Math.max(ans,left+1);
            return 1 + left;
        }
        if(root.right!=null && root.val == root.right.val){
            ans = Math.max(ans,right+1);
            return 1+right;
        }
        return 0;
    }
}