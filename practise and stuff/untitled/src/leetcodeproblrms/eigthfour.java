package leetcodeproblrms;

import java.util.Arrays;
import java.util.Stack;

public class eigthfour {
    public  static int largestRectangleArea(int[] heights) {
        int[][] and = new int[2][heights.length];
        Arrays.fill(and[0],heights.length);
        Arrays.fill(and[1],-1);
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<heights.length;i++){
            if(stack.isEmpty()){stack.add(i);continue;}
            if(heights[stack.peek()]>heights[i]){
                while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                    and[0][stack.peek()]=i;
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    and[1][i]=stack.peek();
                }
                stack.push(i);
            }else {
                and[1][i]=stack.peek();
                stack.push(i);
            }
        }
        int ans =0;
        for(int i =0;i<heights.length;i++){
            ans=Math.max(ans,heights[i]*(and[0][i]-and[1][i]-1));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
