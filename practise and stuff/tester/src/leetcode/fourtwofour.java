package leetcode;
public class fourtwofour {
    public static int characterReplacement(String s, int k) {
        int r =0;
        int l =0;
        int[] table = new int[26];
         int cmax =0;
        int c =0;
        int ans =0;
        int d =0;
        while(r<s.length()){
            int kl =s.charAt(r)-'A';
            table[kl]++;
            if(cmax<table[kl]){
                cmax=table[kl];
                c=kl;
                d=(r-l+1)-cmax;
            }else{d++;}
            if(d<=k){
                ans=Math.max(ans,r-l+1);
                r++;
            }else{
                table[s.charAt(l)-'A']--;
                l++;
                if(table[c]!=cmax){
                    c=find(table);
                    cmax=table[c];
                    d=(r-l+1)-cmax;
                    r++;
                }else{d--;r++;}

            }

        }
        return ans;
    }
    public static int find(int[] table){
        int ans =0;
        int max =0;
        for(int i =0;i<table.length;i++){
            if(max<table[i]){
                ans=i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }
}
