package leetcodeproblrms;

import java.util.Arrays;

public class onefivefivetwo {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int p =-1;
        for (int i = 0; i <position.length; i++) {
            int left =0;
            int right= position[position.length-1]- position[0];
        while(right>=left){
            int mid = left+(right-left)/2;
                if (mid*(m-1)+position[i]<=position[position.length-1]){
                    if (helper(position,mid,position[i], m)){ p=Math.max(p,mid);}
                    left = mid+1;
                }else {
                    right= mid-1;
                }
            }
                    
        }
        return p;
        
    }

    private static boolean helper(int[] position, int mid, int i,int m) {
        if (mid*(m-1)+i>position[position.length-1]){return false;}
        for (int j = 0; j <m-1 ; j++) {
            i+=mid;
            if (!bs(position,i)){return false;}
        }
        return true;

        }

    private static boolean bs(int[] position, int i) {
        int left =0;
        int right = position.length-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            if (position[mid]==i){return true;}
            else if (position[mid]>i){right=mid-1;}
            else{left=mid+1;}
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(  maxDistance(new int[]{5,4,3,2,1,1000000000},2));
    }
}

