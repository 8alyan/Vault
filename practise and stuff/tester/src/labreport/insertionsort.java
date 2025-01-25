package labreport;

import java.util.Random;

public class insertionsort {

    public static void inserted(int[] nums){
        for (int i = 1; i < nums.length ; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (nums[j+1]<nums[j]){
                    int temp = nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }else{break;}
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{23, 12, 56, 34, 90, 54, 31, 77};
        System.out.println("Unsorted array");
        for (int n : nums) {
            System.out.print(n + ",");
        }
        System.out.println();
        inserted(nums);
        System.out.println("Sorted array");
        for (int n : nums) {
            System.out.print(n + ",");
        }
    }
}
