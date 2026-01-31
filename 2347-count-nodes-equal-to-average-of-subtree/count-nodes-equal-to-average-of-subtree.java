
class Solution {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root);
        return count;
    }
    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        int[] total_avg = calculate_sum(root,0);
        int sum = total_avg[0];
        int size = total_avg[1];
        System.out.println(Arrays.toString(total_avg));
        if((sum/size)==root.val){
            count++;
        }
        helper(root.left);
        helper(root.right);
        return;
    }
    public int[] calculate_sum(TreeNode root,int size){
        if(root==null)return new int[]{0,0};
        int[] left = calculate_sum(root.left,size +1 );
        int[] right = calculate_sum(root.right,size +1 );
        return new int[]{root.val + left[0]+ right[0],1+left[1]+right[1]};
    }
}