package leetcode;

import java.util.ArrayList;
import java.util.List;

public class twotwoeight {
    //[["1","0","1","0"],
    // ["1","0","1","1"],
    // ["1","0","1","1"],
    // ["1","1","1","1"]]
    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            int prev=i;
            for(int j =i+1;j<nums.length;j++){
                if(nums[j]==nums[prev]+1){prev=j;continue;}
                else{break;}
            }
            if(nums[i]==nums[prev]){ans.add(""+nums[i]);}
            else{ans.add(nums[i]+"->"+nums[prev]);i=prev;}
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
