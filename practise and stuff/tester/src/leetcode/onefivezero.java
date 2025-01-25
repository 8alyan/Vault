package leetcode;

import java.util.Stack;

public class onefivezero {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ans = new Stack<>();
        for(String n :tokens){
            if(n.equals("*")){
                int a = ans.pop();
                int b = ans.pop();
                ans.push(b*a);
            }
            else if (n.equals("/")){
                int a = ans.pop();
                int b = ans.pop();
                ans.push(b/a);
            }
            else if (n.equals("+")){
                int a = ans.pop();
                int b = ans.pop();
                ans.push(b+a);
            }
            else if(n.equals("-")){
                int a = ans.pop();
                int b = ans.pop();
                ans.push(b-a);
            }
            else{
                ans.push(Integer.parseInt(n));
            }
        }
        return ans.pop();
    }
    public int calculate(String s) {
        int ans =0;
        int ls=1;
        for(char r :s.toCharArray()){
            if(r==')'||r=='('||r==' '){continue;}
            else{
                if(r=='+'){ls=1;}else if (r=='-'){ls=0;}
                else{
                    if (ls==1){
                        ans+=r-'0';
                    }else{
                        ans-=r-'0';
                    }
                }
            }
        }
        return ans;
        }


}
