package leetcodeproblrms;

import java.util.Stack;

public class fourtwo {
    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans =0;
        int[] a = new int[height.length];
        int[] b = new int[height.length];
        for (int i = 0; i <height.length ; i++) {
            if (stack.isEmpty()){a[i]=0;stack.push(height[i]);}
            else{
                if (stack.peek()>height[i]){a[i]=stack.peek();}
                else{
                    a[i]=0;
                    stack.push(height[i]);
                }
            }
        }
        stack=new Stack<>();
        for (int i = height.length-1; i >=0; i--) {
            if (stack.isEmpty()){b[i]=0;stack.push(height[i]);}
            else{
                if (stack.peek()>height[i]){b[i]=stack.peek();}
                else{
                    b[i]=0;
                    stack.push(height[i]);
                }
            }
        }
        for (int i = 0; i < height.length ; i++) {
            int k=Math.min(a[i],b[i])-height[i];
            if(k>0){ans+=k;}
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
