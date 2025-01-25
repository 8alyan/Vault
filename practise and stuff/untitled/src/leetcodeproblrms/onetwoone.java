package leetcodeproblrms;

import java.util.Stack;

public class onetwoone {
    public int maxProfit(int[] prices) {
        int ans =0;
        Stack<Integer> st = new Stack<>();
        for (int i = prices.length-1; i<=0; i++) {
            if (st.isEmpty()){st.push(prices[i]);continue;}
            if (st.peek()>prices[i]){
                ans = Math.max(ans,st.peek()-prices[i]);
            }else{
                st.push(prices[i]);
            }

        }
        return ans;
    }
}
