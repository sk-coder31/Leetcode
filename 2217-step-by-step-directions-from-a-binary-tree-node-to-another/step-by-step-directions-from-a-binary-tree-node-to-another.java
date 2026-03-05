class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {

        TreeNode head = findLCA(root,startValue,destValue);

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        path(head,startValue,left);
        path(head,destValue,right);

        StringBuilder res = new StringBuilder();

        for(int i = 0 ; i < left.length() ; i++){
            res.append('U');
        }

        res.append(right);

        return res.toString();
    }

    public boolean path(TreeNode root,int target,StringBuilder path){
        if(root == null) return false;

        if(root.val == target) return true;

        path.append('L');
        if(path(root.left,target,path)) return true;
        path.deleteCharAt(path.length()-1);

        path.append('R');
        if(path(root.right,target,path)) return true;
        path.deleteCharAt(path.length()-1);

        return false;
    }

    public TreeNode findLCA(TreeNode root,int p,int q){
        if(root == null) return null;

        if(root.val == p || root.val == q) return root;

        TreeNode left = findLCA(root.left,p,q);
        TreeNode right = findLCA(root.right,p,q);

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }
}