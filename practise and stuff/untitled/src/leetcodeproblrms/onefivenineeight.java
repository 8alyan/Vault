package leetcodeproblrms;

import java.util.Stack;

public class onefivenineeight {
    public int minOperations(String[] logs) {
        int z =0;
        for(String s: logs){
            if (s.equals("../")){z=Math.max(z-1,0);}
            else if (!s.equals("./")) {
                z++;
            }
        }
        return z;
    }
}
