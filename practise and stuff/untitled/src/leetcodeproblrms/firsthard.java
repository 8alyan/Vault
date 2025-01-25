package leetcodeproblrms;
class  Solutionfd {
public int findInMountainArray(int target, int[] arr) {
        int peak =peakIndexInMountainArray(arr);
        int start = 0;
        int end = peak;
        int ans = -1;
        while(start<=end){
        int mid = start +(end -start)/2;
        if(arr[mid]<target){
        start = mid+1;
        }
        else if(arr[mid]>target){
        end = mid -1;
        }
        else {
        ans = mid;
        end = mid -1;
        }
        }
        if(ans != -1){return ans;}
        start = peak +1 ;
        end = arr.length -1;
        while(start<=end){
        int mid = start +(end -start)/2;
        if(arr[mid]<target){
        end = mid -1;
        }
        else if(arr[mid]>target){
        start = mid +1;
        }
        else {
        ans = mid;
        end = mid -1;
        }
        }
        return ans ;

        }



public int peakIndexInMountainArray(int[] arr) {
        int start =0;
        int end= arr.length-1;
        while(start<end){
        int mid = start+(end-start)/2;
        if(arr[mid]>arr[mid+1]){
        end = mid;
        }
        else {
        start = mid+1;
        }
        }
        return start;}
        }
public class firsthard {
    public static void main(String[] args) {
        Solutionfd s = new Solutionfd();
        System.out.println(s.findInMountainArray(2,new int[]{1,2,3,4,5,3,1}));
    }
}
