package labreport;

import java.util.Random;

public class selectionsort {
    public static void selection(int[] nums){
        int n = nums.length;
        for (int i = 0; i <n; i++) {
            for (int j = i+1; j <n ; j++) {
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{45,12,9,57,23,89,123,65};
        System.out.println("unsorted");
        for(int l:nums){
            System.out.print(l+" ");
        }
        selection(nums);
        System.out.println();
        System.out.println("Sorted");
        for(int l:nums){
            System.out.print(l+" ");
        }
    }
}
