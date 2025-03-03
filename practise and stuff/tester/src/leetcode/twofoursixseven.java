package leetcode;

import java.util.*;


public class twofoursixseven {
    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int ans =(int)(-1e9);
        boolean[] isleaf = new boolean[amount.length];
        ArrayList<ArrayList<Integer>> t1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> t2 = new ArrayList<>();
        for(int i =0;i<amount.length;i++){
            t1.add(new ArrayList<>());
            t2.add(new ArrayList<>());
        }
        for(int[] e:edges){
            t1.get(e[0]).add(e[1]);
            isleaf[e[0]]=true;
            t1.get(e[1]).add(e[0]);
        }
        Set<Integer> path = new HashSet<>();
        
        Map<Integer,Integer> map = new HashMap<>();
        bobby(t1,bob,-1,new ArrayList<>(),map);
        return helper(t1,0,0,0,amount,path,map);
    }

    private static int helper(ArrayList<ArrayList<Integer>> t1, int alice, int i1, int i2, int[] amount, Set<Integer> path, Map<Integer, Integer> bp) {
        int ans = (int)(-1e9);
        path.add(alice);
        if(bp.containsKey(alice)){
            int i3=bp.get(alice);
            if(i2==i3){
            i1+=amount[alice]/2;}
            else if (i2<i3) {
                i1+=amount[alice];
            }
        }else{
            i1+=amount[alice];
        }
        if(t1.get(alice).size()==1&&path.contains(t1.get(alice).get(0))){path.remove(alice);return i1;}
        for(int i =0;i<t1.get(alice).size();i++){
            int a = t1.get(alice).get(i);
            if(path.contains(a)){continue;}
                ans =Math.max(helper(t1,a,i1,i2+1,amount,path,bp),ans);
        }
        path.remove(alice);
        return ans;
    }
    public static void bobby(ArrayList<ArrayList<Integer>> t1, int bob,int bobp,List<Integer> path , Map<Integer, Integer> bp){
        path.add(bob);
        if(bob==0){
            for (int i = 0; i <path.size() ; i++) {
                bp.put(path.get(i),i);
            }
            return;
        }
        for (int i = 0; i <t1.get(bob).size() ; i++) {
            if(bobp!=t1.get(bob).get(i)){
                bobby(t1,t1.get(bob).get(i),bob,path,bp);
                path.removeLast();
            }
        }
        
    }
    public static void main(String[] args) {
        System.out.println(mostProfitablePath(new int[][]{{0,2},{0,6},{1,3},{1,5},{2,5},{4,6}},6,new int[]{8838,-6396,-5940,2694,-1366,4616,2966}));
    }
}
