package labreport;

import java.util.Scanner;

public class readandwriteconsole {
    public static void main(String[] args) {
        Scanner r =  new Scanner(System.in);
        System.out.println("Enter the length of array ");
        int n = r.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            System.out.println("Enter the value for " +(i+1)+ "th element");
            int k = r.nextInt();
            nums[i]=k;
        }
        System.out.println("Your Entered Array Is :");
        for (int i = 0; i <n ; i++) {
            if(i==n-1){System.out.print(nums[i]);}
            else{
                System.out.print(nums[i]+",");
            }
        }
    }
}
