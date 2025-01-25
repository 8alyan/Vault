package labreport;

public class armstrong {
    public static boolean armstrongornot(int n){
        int pow = (int)Math.log10(n)+1;
        int z=n;
        int ans =0;
        while(z!=0){
            int k = 1;
            for (int i = 0; i <pow ; i++) {
                k*=z%10;
            }
            ans+=k;
            z=z/10;
        }
        return n==ans;
    }

    public static void main(String[] args) {

        int n = 153;
        if(armstrongornot(n)){
            System.out.println(n+" is an armstrong no ");
        }else{
            System.out.println(n+" is not an armstrong no ");
        }
    }
}
