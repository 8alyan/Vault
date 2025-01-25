package leetcodeproblrms;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class sevenfivetwo {
    public static int openLock(String[] deadends, String target) {
        Queue<String> sd = new LinkedList<>();
        boolean[] vis = new boolean[10000];
        for (String deadend : deadends) {
            vis[Integer.parseInt(deadend)] = true;
        }
        int lvl =-1;
        sd.add("0000");
        while(!sd.isEmpty()){
            int size = sd.size();
            lvl++;
            for (int i = 0; i <size ; i++) {
            String p = sd.remove();
            if (p.equals(target)){return lvl;}
            if (!vis[Integer.parseInt(p)]){
                vis[Integer.parseInt(p)]=true;
                String[] po = all(p);
                for (int j = 0; j <po.length ; j++) {
                    if (!vis[Integer.parseInt(po[j])]){sd.add(po[j]);}
                }


            }
        }}
        return -1;
    }

    private  static String[] all(String p) {
        char ogone = p.charAt(0);
        char ogtwo = p.charAt(1);
        char ogthree = p.charAt(2);
        char ogfour = p.charAt(3);
        char one =(char)((p.charAt(0)+1)>57?48:(p.charAt(0)+1));
        char two =(char)((p.charAt(0)-1)<48?57:(p.charAt(0)-1));
        char three =(char)((p.charAt(1)+1)>57?48:(p.charAt(1)+1));
        char four =(char)((p.charAt(1)-1)<48?57:(p.charAt(1)-1));
        char five =(char)((p.charAt(2)+1)>57?48:(p.charAt(2)+1));
        char six =(char)((p.charAt(2)-1)<48?57:(p.charAt(2)-1));
        char seven =(char)((p.charAt(3)+1)>57?48:(p.charAt(3)+1));
        char eight =(char)((p.charAt(3)-1)<48?57:(p.charAt(3)-1));
        String[] ans = new String[8];
        ans[0]=""+ogone+ogtwo+ogthree+seven;
        ans[1]=""+ogone+ogtwo+ogthree+eight;
        ans[2]=""+ogone+ogtwo+five+ogfour;
        ans[3]=""+ogone+ogtwo+six+ogfour;
        ans[4]=""+ogone+three+ogthree+ogfour;
        ans[5]=""+ogone+four+ogthree+ogfour;
        ans[6]=""+one+ogtwo+ogthree+ogfour;
        ans[7]=""+two+ogtwo+ogthree+ogfour;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));}
    }

