package leetcodeproblrms;

import java.util.ArrayList;

public class dp52 {
    public static int evaluateExp(String exp) {
        return rola(exp,0,exp.length()-1,true);
    }
    public static int rola(String exp,int i ,int j,boolean it){
        if (i==j){if(it){return exp.charAt(i)=='T'?1:0;}
        else{
            return exp.charAt(i)=='T'?0:1;
        }
        }
        int maxit = 0;
        int maxif=0;
        for (int k = i+1; k<j ; k=k+2) {
            int rec1t=rola(exp,i,k-1,true);
            int rec1f=rola(exp,i,k-1,false);
            int rec2t=rola(exp,k+1,j,true);
            int rec2f=rola(exp,k+1,j,false);
            if (exp.charAt(k)=='|'){
                maxit+=rec1t*rec2t+rec1t*rec2f+rec2t*rec1f;
                maxif+=rec1f*rec2f;
            }
            else if (exp.charAt(k)=='&'){
                maxit+=rec1t*rec2t;
                maxif+=rec2t*rec1f+rec1t*rec2f+rec1f*rec2f;
            }
            else{
                maxit+=rec2t*rec1f+rec1t*rec2f;
                maxif+=rec2t*rec1t+rec1f*rec2f;
            }
        }
        if(it){return maxit;}
        else{return maxif;}
    }

    public static void main(String[] args) {
        System.out.println(evaluateExp("T^T^F"));
    }
}
