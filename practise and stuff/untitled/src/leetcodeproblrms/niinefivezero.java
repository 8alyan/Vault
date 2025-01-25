package leetcodeproblrms;

import java.util.Arrays;

public class niinefivezero {
    public static int[] deckRevealedIncreasing(int[] deck) {
        int[] ans = new int[deck.length];
        Arrays.sort(deck);
        int n = 0;
        int i = 0;
        int j =0;
        boolean t =true;
        while (n!=deck.length){
            if(i>=deck.length){
                i=0;
            }
            if (ans[i]==0){
                if (t){
                    ans[i]=deck[j];
                    j++;
                    t=false;
                    n++;
                }else {
                    t=true;
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }
}
