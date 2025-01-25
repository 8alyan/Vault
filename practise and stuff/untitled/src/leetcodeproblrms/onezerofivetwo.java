package leetcodeproblrms;

public class onezerofivetwo {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans =0;
        for (int i = 0; i <= customers.length-minutes ; i++) {
            int a =0;
            for (int j = 0; j <i ; j++) {
                if (grumpy[j]==0){a+=customers[j];}
            }
            for (int j = i; j<i+minutes ; j++) {
                a+=customers[j];
            }
            for (int j = i+minutes; j < customers.length ; j++) {
                if (grumpy[j]==0){a+=customers[j];}
            }
            ans=Math.max(ans,a);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3));
    }
}
