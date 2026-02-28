class Solution {
    public int rob(TreeNode root) {
        //(rob,skip)
        int[] op = helper(root);
        return Math.max(op[0],op[1]);
    }
    public int[] helper(TreeNode root){
        if(root == null){
            return new int[2];
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        //(rob,skip)
        int rob = Math.max(left[1]+right[1]+root.val,root.val);
        int skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob,skip};
    }
}