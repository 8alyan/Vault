package leetcode;

import java.util.Stack;

public class threeonesevenfour {
    public String clearDigits(String s) {
        Stack<Character> ans = new Stack<>();
        for(char r:s.toCharArray()){
            if(r>='0'&&r<='9'){
                if(!ans.isEmpty()){
                    ans.pop();
                }}else{
                    ans.push(r);
                }
            }

        StringBuilder zaza = new StringBuilder();
        while (!ans.isEmpty()){
            zaza.append(ans.pop());
        }
        return zaza.reverse().toString();
    }

    public static void main(String[] args) {
        threeonesevenfour s = new threeonesevenfour();
        System.out.println(s.clearDigits("a4b5c"));
    }
}
