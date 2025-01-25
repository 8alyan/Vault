package leetcodeproblrms;
// trust[i][0]!=trust[i][1]
//trust[i][0]==1,2,3,4,5,.....n
class Solutions {
    public int findJudge(int n, int[][] trust) {
        for (int i =1;i<=n;i++){
            int trustfac =0;
            for (int j =0;j< trust.length;j++){
                if (trust[j][0]==i){trustfac=0;
                break;}
                if (trust[j][1]==i){
                    trustfac++;
                }}
              if (trustfac==n-1){
                return i;}
              }
        return -1;}
    }
public class findthetownjudge {
    public static void main(String[] args) {
        Solutions s = new Solutions();
        int[][] trust = {{1,2},{2,3}};
        System.out.println( s.findJudge(3,trust));
    }
}
