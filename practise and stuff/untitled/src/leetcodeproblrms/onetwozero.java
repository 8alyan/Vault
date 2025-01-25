package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class onetwozero {
    public static int minimumTotal(List<List<Integer>> triangle) {
//        List<List<Integer>> dp = new ArrayList<>();
//        for (int i = 0; i <triangle.size() ; i++) {
//            dp.add(new ArrayList<>());
//            for (int j = 0; j <triangle.get(i).size() ; j++) {
//                dp.get(i).add(0);
//            }
//        }
        int ans =(int)(1e9);
        for (int i = triangle.size()-2; i>=0 ; i--) {
            for (int j = triangle.get(i).size()-1; j>=0 ; j--) {
                int a =triangle.get(i+1).get(j)+triangle.get(i).get(j);
                int b =triangle.get(i+1).get(j+1)+triangle.get(i).get(j);
                triangle.get(i).set(j,Math.min(a,b));
            }
        }
        return triangle.getFirst().getFirst();

    }

    private static int dam(List<List<Integer>> dp,List<List<Integer>> triangle, int i,int j ) {
        if (i==triangle.size()-1){return triangle.get(i).get(j);}
        if (j>=triangle.get(i).size()){return (int)(1e9);}
        if (dp.get(i).get(j)!=0){return dp.get(i).get(j);}
        int a = dam(dp,triangle,i+1,j)+triangle.get(i).get(j);
        int b = dam(dp,triangle,i+1,j+1)+triangle.get(i).get(j);
        dp.get(i).set(j,Math.min(a,b));
        return Math.min(a,b);

    }

    public static void main(String[] args) {
        // Create individual lists
        List<Integer> list1 = Arrays.asList(-10);

        // Create a list of lists
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(list1);

        System.out.println(minimumTotal(listOfLists));
    }
}
