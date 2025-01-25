package leetcodeproblrms;

public class nineninetwo {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }

    private static int helper(int[] nums, int k) {
        int m =0;
        int ans =0;
        int[] fre = new int[nums.length+1];
        for(int right =0,left =0;right< nums.length;right++){
            fre[nums[right]]++;
            if (fre[nums[right]]==1){m++;}
            while (m>k){
                fre[nums[left]]--;
                if (fre[nums[left]]==0){m--;}
                left++;
            }
            ans+=(right-left+1);

        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(subarraysWithKDistinct(new int[]{1,2},1));
        String a ="abc";
        String b ="bcd";
        StringBuilder d= new StringBuilder() ;
        d.append('d');

        d.insert(0,'c');
        d.deleteCharAt(0);
        System.out.println(d);
    }
}
