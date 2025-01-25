package leetcode;
import java.util.*;

public class fivethreenine {
    public int findMinDifference(List<String> timePoints){
       List<Integer> df = new ArrayList<>();
        for (int i = 0; i < timePoints.size() ; i++) {
            df.add(diffrence(timePoints.get(i)));
        }
        Collections.sort(df);
        int ans =24*60;
        for (int i = 0; i <df.size()-1 ; i++) {
            int z = Math.abs(df.get(i)-df.get(i+1));
            ans=Math.min(ans,Math.min(z,1440-z));
        }
        int z = Math.abs(df.get(0)-df.get(df.size()-1));
        ans=Math.min(ans,1440-z);
        return ans;
    }
    public int diffrence(String a){
        //48-57
        int a1 =(a.charAt(0)-(48))*10;
        a1+=(a.charAt(1)-(48));
        a1*=60;
        a1+=(a.charAt(3)-48)*10;
        a1+=(a.charAt(4)-48);

        return a1;
    }
}
