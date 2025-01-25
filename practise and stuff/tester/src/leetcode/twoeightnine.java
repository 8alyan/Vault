package leetcode;

public class twoeightnine {
    public static void gameOfLife(int[][] board) {
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(i==1&&j==1){
                    System.out.println();
                }
                int og =board[i][j];
                int nei=0;
                if(i!=0){
                    if(board[i-1][j]<10&&board[i-1][j]>0){nei++;}
                    if(j!=0){
                        if(board[i-1][j-1]<10&&board[i-1][j-1]>0){nei++;}
                    }
                    if(j<board[0].length-1){
                        if(board[i-1][j+1]<10&&board[i-1][j+1]>0){nei++;}
                    }
                }
                if(j<board[0].length-1){
                    if(board[i][j+1]<10&&board[i][j+1]>0){nei++;}
                }
                if(j!=0){
                    if(board[i][j-1]<10&&board[i][j-1]>0){nei++;}
                }

                if(i<board.length-1){
                    if(board[i+1][j]<10&&board[i+1][j]>0){nei++;}
                    if(j!=0){
                        if(board[i+1][j-1]<10&&board[i+1][j-1]>0){nei++;}
                    }
                    if(j<board[0].length-1){
                        if(board[i+1][j+1]<10&&board[i+1][j+1]>0){nei++;}
                    }
                }
                if(og==0){board[i][j]=10+nei;}
                else{board[i][j]=nei+1;}

            }
        }
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(board[i][j]<10){
                    board[i][j]--;
                    if(board[i][j]<2){board[i][j]=0;}
                    else if(board[i][j]<4){board[i][j]=1;}
                    else{board[i][j]=0;}
                }
                else{
                    board[i][j]=board[i][j]-10;
                    if(board[i][j]==3){board[i][j]=1;}
                    else{board[i][j]=0;}
                }
            }
        }
     }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {1, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0}
        };
        gameOfLife(board);
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                System.out.print(board[i][j]+",");
            }
            System.out.println();
        }
    }
}
