class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sc = new StringBuilder();
        dp(sc, root);
        return sc.toString();

    }

    public void dp(StringBuilder sc, TreeNode root) {
        if (root == null) {
            return;
        }
        sc.append(root.val);
        if(root.left!=null && root.right==null){
            sc.append("(");
            dp(sc,root.left);
            sc.append(")");
        }
        if(root.left==null && root.right!=null){
            sc.append("(");
            sc.append(")");
            sc.append("(");
            dp(sc,root.right);
            sc.append(")");
        }
        if(root.left!=null && root.right!=null){
            sc.append("(");
            dp(sc,root.left);
            sc.append(")");
            sc.append("(");
            dp(sc,root.right);
            sc.append(")");
        }
        return;
    }
}