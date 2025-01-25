package leetcode;

public class onethreefour {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int togas =0;
        int toco=0;
        for(int i =gas.length-1;i>=0;i--){
            togas+=gas[i];
            toco+=cost[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] gas =  {5,1,2,3,4};
        int [] cost = {4,4,1,5,1};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
