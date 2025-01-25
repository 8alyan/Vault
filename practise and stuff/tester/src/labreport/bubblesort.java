package labreport;

import java.util.Random;

public class bubblesort {


    public static void bubble(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
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
        bubble(nums);
        System.out.println("Sorted array");
        for (int n : nums) {
            System.out.print(n + ",");
        }
    }}

