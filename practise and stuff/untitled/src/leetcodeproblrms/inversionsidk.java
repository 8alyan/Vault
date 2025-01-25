package leetcodeproblrms;

import java.util.*;

public class inversionsidk {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length ; i++){
            if (hm.containsKey(nums[i])){return new int[]{hm.get(nums[i]),i};}
            else{hm.put(target-nums[i],i);}
        }
        return new int[]{-1,-1};
    }
     static int ans =0;
    public static void mergeSort(long arr[],int s , int e ){
        if(s>=e){return ;}
        int mid = (e+s)/2;
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        merge(arr,s,e,mid);
    }

    private static void merge(long[] arr, int s, int e, int mid) {
        ArrayList<Long> temp =  new ArrayList<>();
        int left=s;
        int right=mid+1;
        while(left<=mid&&right<=e){
            if (arr[left]>arr[right]){
                temp.add(arr[right]);
                right++;
            }else {
                temp.add(arr[left]);
                left++;
            }

        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=e){
            temp.add(arr[right]);
            right++;
        }
        for (int i = 0; i <temp.size() ; i++) {
            arr[s+i]=temp.get(i);
        }
    }

    public static long getInversions(long arr[], int n) {
        mergeSort(arr,0,n);
        return ans;
    }

    public static void main(String[] args) {
        long[] sa = new long[]{2,5,1,3,4};
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(ans);
    }
}
