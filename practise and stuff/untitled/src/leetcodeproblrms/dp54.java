package leetcodeproblrms;

public class dp54 {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        return iski(arr,0,k);
    }

    public static int iski(int[] arr, int i, int k) {
        if(i>=arr.length){return 0;}
        int ans =0;
        for (int j = 1; j <= k&&i+j<=arr.length ; j++) {
             int par= maxi(arr,i,i+j);
             ans=Math.max(par*j+iski(arr,i+j,k),ans);
        }
        return ans;
    }
    public static int maxi(int [] arr,int i ,int j){
        int ans=0;
        for (int k = i; k <j ; k++) {
            ans=Math.max(arr[k],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{10,9,3,2},2));
    }
}
