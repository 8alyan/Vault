package leetcodeproblrms;

public class sevenfour {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l =0;
        int r= matrix.length-1;
        int found =-1;
        while(l<=r){
            int m = (r+l)/2;
            if (target<=matrix[m][matrix[0].length-1]&&target>=matrix[m][0]){
                found =m;
                break;
            } else if (target>matrix[m][matrix[0].length-1]){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        if (found==-1){return false;}
        else{
            l=0;
            r= matrix[0].length-1;
            while (l<=r){
                int m = r-(r-l)/2;
                if (matrix[found][m]==target){return true;}
                else if (matrix[found][m]>target) {
                    r=m-1;
                }else{l=m+1;}
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] demo ={{1},{3}};
        System.out.println(searchMatrix(demo,0));
    }
}
