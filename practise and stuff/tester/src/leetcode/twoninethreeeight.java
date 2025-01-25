package leetcode;

public class twoninethreeeight {
    public static long minimumSteps(String s) {
        long ans =0;
        int left =0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='0'){
                ans+=i-left;
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumSteps("111111111100100010"));
    }
}
