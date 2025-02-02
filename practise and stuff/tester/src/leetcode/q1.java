package leetcode;

public class q1 {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for(char r :s.toCharArray()){
            freq[r-'a']++;
        }
        int ho=0;
        int he=0;
        int le=s.length();
        for(int i =0;i<26;i++){
            if(freq[i]==0){continue;}
            if(freq[i]%2==0){
                le=Math.min(le,freq[i]);
            }
            else{
                ho=Math.max(ho,freq[i]);
            }
        }
        return Math.abs(ho-le);
    }
    public int maxDistance(String s, int k) {
        int n =0;
        int e =0;
        int ans=0;
        for(int i =0;i<s.length();i++){
            char r =s.charAt(i);
            if(r=='N'){n++;}
            if(r=='S'){n--;}
            if(r=='W'){e--;}
            if(r=='E'){e++;}
            int d = Math.abs(n)+Math.abs(e);
            if(d==i+1){
                d=Math.min(d+k,s.length());
            }
            else{
                int c =k;
                int z = i+1-d;
                z/=2;
                if(z<=c){d+=z*2;c-=z;}
                d= Math.min(d + c, s.length());
            }
            ans=Math.max(d,ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        q1 q = new q1();
        System.out.println(q.maxDistance("SNWWEEW",2));
    }
}
