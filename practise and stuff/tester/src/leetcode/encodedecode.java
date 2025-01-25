package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class encodedecode {
    public static String encode(List<String> strs) {
        StringBuilder zaza = new StringBuilder();
        for(String z:strs){
            zaza.append(z);
            zaza.append(" ");
        }
        return zaza.toString();
    }

    public static List<String> decode(String str) {
        if (str.isEmpty()){return new ArrayList<>();} if (str.isEmpty()){return new ArrayList<>();}
        if(Objects.equals(str, " ")){
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        String[] zaza = str.split(" ");
        List<String> ans = new ArrayList<>();
        ans.addAll(Arrays.asList(zaza));
        return ans;
    }

    public static void main(String[] args) {
        List<String> in = new ArrayList<>();
        System.out.println(decode(encode(in)));
    }
}
