class Solution {
    public int sumRootToLeaf(TreeNode root) {
        String str = "";
        return helper(root,str);
    }
    public int helper(TreeNode root,String str){
        if(root == null)return 0;
        if(root.left == null && root.right == null){
            int n = Integer.parseInt(str+Integer.toString(root.val),2);
            return n;
        }
        int left = helper(root.left,str+Integer.toString(root.val));
        int right = helper(root.right,str+Integer.toString(root.val));

        return left + right; 

    }
}