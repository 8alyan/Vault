package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class seventyone {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> set = new HashSet<>();
        Set<String> asli = new HashSet<>();
        String[] s11= s1.split(" ");
        String[] s22= s2.split(" ");
        for(String n :s11){
            if(set.add(n)){asli.add(n);}
            else{
                asli.remove(n);
            }

        }
        for(String n :s22){
            if(set.add(n)){asli.add(n);}
            else{
                asli.remove(n);
            }
        }
        return asli.toArray(new String[0]);
    }
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        for(String r :arr){
          if(r.isEmpty()){continue;}
          if(r.equals("..")){stack.pop();}
          else{stack.push(r);}
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            ans.insert(0,stack.pop());
            ans.insert(0,"/");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath( "/home//user/Documents/../Pictures"));
    }
}
