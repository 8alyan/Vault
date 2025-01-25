package leetcodeproblrms;

public class fourzerofour {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root,false);
        return ans;
    }
    int ans =0;
    public void helper(TreeNode root,boolean m ){

        if (m&&(root.left==null&&root.right==null)){
            ans+=root.val;
        }
        if(root.left!=null){helper(root.left,true);}
        if(root.right!=null){helper(root.right,false);}
    }

}
