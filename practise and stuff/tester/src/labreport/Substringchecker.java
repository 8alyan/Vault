package labreport;

public class Substringchecker {
    public static boolean substring(String a ,String b){
        if(a.equals(" ")&&b.equals(" ")){return true;}
        if(a.equals(" ")||b.equals(" ")){return false;}
        int b1=0;
        for (int i = 0; i <a.length()&&b1<b.length(); i++) {
            if (a.charAt(i)==b.charAt(b1)){b1++;}
            else{b1=0;}
        }
        return b1==b.length();
    }
    public static void main(String[] args) {
        System.out.println(substring("ABCDDDEFCKLOCK","LOCK"));
    }
}
