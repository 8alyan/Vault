package leetcodeproblrms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class fourfivetwo {
    public int findMinArrowShots(int[][] points) {
        ArrayList<int[]> ans = new ArrayList<>(Arrays.asList(points));
        ans.sort(Comparator.comparingInt(o -> o[0]));
        int i =0;
        while(i < ans.size()-1) {
            if(ans.get(i)[1]<ans.get(i+1)[0]){i++;}
            else{
                int start1 = ans.get(i)[0];
                int end1 = ans.get(i)[1];
                int start2 = ans.get(i+1)[0];
                int end2 = ans.get(i+1)[1];
                ans.remove(i);
                ans.remove(i);
                ans.add(i,new int[]{Math.min(start1,start2),Math.max(end1,end2)});
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        fourfivetwo t = new fourfivetwo();
        t.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}});
    }
}
