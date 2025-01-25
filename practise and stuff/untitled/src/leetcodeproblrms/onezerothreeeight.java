package leetcodeproblrms;

import java.util.ArrayList;

public class onezerothreeeight {
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
 int sd=0;
    public TreeNode bstToGst(TreeNode root) {
        traversal(root);
        return root;
    }


    private void traversal(TreeNode root) {
        if (root==null){return;}
        traversal(root.right);
        sd+= root.val;
        root.val=sd;
        traversal(root.left);

}}
