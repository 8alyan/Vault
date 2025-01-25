package leetcode;

import java.util.HashMap;
import java.util.Map;

public class onefournineseven {
    public static  boolean canArrange(int[] arr, int k) {
        int[] re = new int[2*k-1];
        for(int n :arr){
            re[n%k+k-1]++;
        }
        if(re[k-1]%2!=0){return false;}
        for (int i = 0; i < re.length ; i++) {
            if(i==k-1){continue;}
            if(i>k-1){
                if((re[i]!=(k-1)-(i-(k-1)))&&(re[i]!=re[(re.length)-(i-(k-1))])){return false;}
            }
            else {
            if(re[i]!=re[re.length-1-i]&&re[i]!=re[k-2-i]){return false;}}
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canArrange(new int[]{-4,-7,5,2,9,1,10,4,-8,-3},3));
    }
}
