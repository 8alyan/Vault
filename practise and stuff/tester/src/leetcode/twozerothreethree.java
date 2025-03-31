package leetcode;

public class twozerothreethree {
    public static int minOperations(int[][] grid, int x) {
        int s=0;
        int r =-1;
        int i =0;
        for(int[] g:grid){
            for(int n:g){
                if(r!=-1&&r!=n%x){return -1;}
                r=n%x;
                s+=n/x;
            }
        }
        int avg=s/(grid.length*grid[0].length);
        int cl =0;
        for(int[] g:grid){
            for(int n:g){
                if(Math.abs(n/x-avg)<Math.abs(avg-cl)){cl=n/x;}
            }
        }
        int ans=0;
        for(int[] g:grid){
            for(int n:g){
                ans+=Math.abs(n/x-cl);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[][]{{931,128},{639,712}},73));
    }
}
