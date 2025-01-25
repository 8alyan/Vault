package labreport.ads;

public class lecture1 {

    public static int sumofarrayelements(int[] nums){
        int sum =0;
        for(int n :nums){
            sum+=n;
        }
        return sum;
    }


    public static int largestelementinarray(int[] nums){
        int max =-(int)(1e9);
        for (int n:nums){
            if(n>max){max=n;}
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = new int[]{2,4,6,2,6,12,45,78};
        System.out.println(sumofarrayelements(nums));
    }

}
