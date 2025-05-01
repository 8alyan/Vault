package leetcode;

public class twoeightfourthree {
    public int countSymmetricIntegers(int low, int high) {
        int ans =0;
        for (int i = low; i <high ; i++) {
            if(((int)Math.log10(i)+1&1)==1){continue;}
            else{
                if(helper(i)){ans++;}
            }
        }
        return ans;
    }
    public String countAndSay(int n) {
        String ans ="1";
        for(int i =1;i<n;i++){
            StringBuilder za = new StringBuilder();
            for(int j =0;j<ans.length();j=j){
                char c = ans.charAt(j);
                int k =j+1;
                int m =1;
                while(k<ans.length()&&ans.charAt(k)==c){
                    m++;k++;
                }
                za.append((char)('0'+m));
                za.append(c);
                j=k;
            }
            ans=za.toString();
        }
        return ans;
    }
    public boolean helper(int i ){
        String g = Integer.toString(i);
        int k =0;
        int l =0;
        for (int j = 0; j <g.length(); j++) {
            int r = (int)(g.charAt(j)-'0');
            if(j<g.length()/2){
                k+=r;
            }else{
                l+=r;
            }
        }
        return k==l;
    }

    public static void main(String[] args) {
       twoeightfourthree g = new twoeightfourthree();
        System.out.println(g.countAndSay(4));

    }
}
