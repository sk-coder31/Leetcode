class Solution {
    long max = 0;
    long total = 0;
    int MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        total = getTotalSum(root);
        dfs(root);
        return (int)(max % MOD);
    }
    public int getTotalSum(TreeNode root){
        if(root == null)return 0;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }
    public long dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        long left = dfs(root.left);
        long right = dfs(root.right);
        long sub_sum = root.val + left + right;

        long prod = sub_sum * (total - sub_sum);
        max = Math.max(max,prod);
        return sub_sum;
        
    }

}