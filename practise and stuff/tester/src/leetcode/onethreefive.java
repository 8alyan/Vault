package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class onethreefive {
    public static int candy(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int ans =0;
        for(int i =0;i<dp.length;i++){
            boolean a=false;
            boolean b=false;
            if(i>0&&nums[i]>nums[i-1]){a=true;}
            if(i<nums.length-1&&nums[i]>nums[i+1]){b=true;}
                if(a&&b){dp[i]=Math.max(dp[i-1],dp[i+1])+1;}
                else if(a){dp[i]=dp[i-1]+1;}
                else if(b){dp[i]=dp[i+1]+1;}
        }
        for(int i =dp.length-1;i>=0;i--){
            boolean a=false;
            boolean b=false;
            if(i>0&&nums[i]>nums[i-1]){a=true;}
            if(i<nums.length-1&&nums[i]>nums[i+1]){b=true;}
            if(a&&b){dp[i]=Math.max(dp[i-1],dp[i+1])+1;}
            else if(a){dp[i]=dp[i-1]+1;}
            else if(b){dp[i]=dp[i+1]+1;}

            ans+=dp[i];
        }
        return ans;
    }
    public static boolean wordPattern(String pattern, String s) {
        Map<String,Character> amp = new HashMap<>();
        String[] ss= s.split(" ");
        for(int i =0;i<pattern.length();i++){
          if(amp.containsKey(ss[i])){if(!amp.get(ss[i]).equals(pattern.charAt(i))){return false;}}
          else{if(amp.containsValue(pattern.charAt(i))){return false;}
              else{amp.put(ss[i],pattern.charAt(i));}
          }
        }
        return true;
    }
    public static boolean isPalindrome(String s) {
        //  48-57
        // 65-90
        // 97-122
        int left =0;
        int right = s.length()-1;
        while(right>left){
            int r =(int)s.charAt(right);
            int l =(int)s.charAt(left);
            if(l==0){left++;}
            if(r==0){right--;}
            if(l>=65&&l<=90){l=l+32;}
            if(r>=65&&r<=90){r=r+32;}
            if(!((l>=48&&l<=57)||(l>=97&&l<=122))){left++;continue;}
            if(!((r>=48&&r<=57)||(r>=97&&r<=122))){right--;continue;}
            if(r!=l){return false;}
            else{left++;right--;}
        }
        return true;
    }
}
