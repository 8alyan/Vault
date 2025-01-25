package leetcodeproblrms;

import java.util.ArrayList;
import java.util.List;

public class oneonenine {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if(rowIndex==0){return ans;}
        ans.add(1);
        for(int i =1;i<rowIndex;i++){
            List<Integer> as = new ArrayList<>();
            for(int j =0;j<=ans.size();j++){
                int l =j==ans.size()?0:ans.get(j);
                int r = j==0?0:ans.get(j-1);
                as.add(l+r);
            }
            ans=as;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
