package labreport.ads;
import java.util.Arrays;
import java.util.Random;

public class search {


    public static int linearsearch(int[] nums, int target){
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]==target){return i;}
        }
        return -1;
    }
   

    public static int binarysearch(int[] nums,int target){
        int left =0;
        int right = nums.length-1;
        while(right>=left){
            int mid = right-(right-left)/2;
            if(nums[mid]==target){return mid;}
            else if (nums[mid]>target) {right=mid-1;}
            else{left=mid+1;}
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{12,23,45,56,65,78,98};
        System.out.println(linearsearch(nums, 56));
        System.out.println(linearsearch(nums, 99));
     }


}
