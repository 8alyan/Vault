package leetcode;

public class fourtofour {
    public int characterReplacement(String s, int k) {
        int[] f = new int[26];
        int ans =0;
        int r =0;
        int l =0;
        int most=0;
        int pmost=0;
        int d =0;
        while(r<s.length()){
            int cur = s.charAt(r)-'A';
            f[cur]++;
            if(f[most]<=f[cur]){
                pmost=most;
                most=cur;
                d=r-l+1-f[most];
            }else{d++;}
            while(d>k){
                int lcur =s.charAt(l)-'A';
                f[lcur]--;l++;
                if(lcur!=most){d--;}
                else{
                    if(f[pmost]>f[most]){
                        most=pmost;
                    }
                    d=r-l+1-f[most];
                }
            }
            ans=Math.max(r-l+1,ans);
            r++;

        }
        return ans;
    }
    public int find(int[] f){
        int m =0;
        for(int i =0;i<f.length;i++){
            if(f[m]<f[i]){
                m=i;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        fourtofour r = new fourtofour();
        System.out.println(r.characterReplacement("AAAAABBBBCBB",4));
    }
}
