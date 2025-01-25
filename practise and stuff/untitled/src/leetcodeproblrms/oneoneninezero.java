package leetcodeproblrms;

public class oneoneninezero {
     static int i =0;
    public static String reverseParentheses(String s) {
        char[] r= s.toCharArray();
        return hel(r);
        }

    private static String hel( char[] s) {
        StringBuilder sb = new StringBuilder();
        while(i<s.length){
            if (s[i]==')'){
                i++;
                return sb.reverse().toString();
            }
            else if(s[i]=='('){
                i++;
                String st = hel(s);
                sb.append(st);
            }else
            {sb.append(s[i]);
            i++;}
        }
        return sb.toString();
}

    public static void main(String[] args) {
        System.out.println(reverseParentheses( "(u(love)i)"));
    }
}
