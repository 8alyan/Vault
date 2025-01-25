package leetcode;

public class oneninefourfive {
    public static int getLucky(String s, int k) {
        long n =0;
        for(int i =0;i<s.length();i++){
            int z=(s.charAt(i)-'`');
            while(z!=0){
                n+=z%10;
                z=z/10;
            }
        }
        k--;
        while(k!=0){
            k--;
           long sum =0;
           while(n!=0){
               sum+=n%10;
               n=n/10;
           }
           n=sum;
        }
        return (int)n;
    }

    public static void main(String[] args) {
        System.out.println(getLucky("dbvmfhnttvr",5));
    }
}
