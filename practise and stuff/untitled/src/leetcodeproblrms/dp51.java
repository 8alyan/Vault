package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;

public class dp51 {
    public static int maxCoins(int[] nums) {
        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);for(int n :nums){num.add(n);}num.add(1);
        return whatra(num,1,nums.length);
    }
    public static int whatra(ArrayList<Integer> num,int i ,int j){
        if(j<i||i==0||j==num.size()){return 0;}
        if(i==j){return num.get(i-1)*num.get(i)*num.get(j+1);}
        int maxi =Integer.MIN_VALUE;
        for(int k =i;k<=j;k++){
            int res= num.get(i-1)*num.get(k)*num.get(j+1);
            int rec = whatra(num,i,k-1)+whatra(num,k+1,j);
            maxi=Math.max(maxi,res+rec);
        }
        return maxi;
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }
}
