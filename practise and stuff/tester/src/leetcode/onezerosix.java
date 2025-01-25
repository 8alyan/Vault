package leetcode;

public class onezerosix {
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

        public  TreeNode buildTree(int[] inorder, int[] postorder) {
            return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        }
        public  TreeNode helper(int[] inorder,int[] postorder,int is,int ie,int ps,int pe){
            if(is>ie||ps>pe){return null;}
            int val = postorder[pe];
            TreeNode root = new TreeNode(val);
            int k =-1;
            int l =-1;
            for(int i =is;i<=ie;i++){
                if(inorder[i]==val){
                    k=i;
                    if(i!=0){
                        l=inorder[i-1];}
                    break;}
            }
            for(int i =ps;i<=pe;i++){
                if(postorder[i]==l){l=i;break;}
            }
            root.left=helper(inorder,postorder,is,k-1,ps,l);
            root.right=helper(inorder,postorder,k+1,ie,l+1,pe-1);
            return root;

        }

    public static void main(String[] args) {
        onezerosix s = new onezerosix();
        s.buildTree(new int[]{2,3,1},new int[]{3,2,1});
    }
    }

