package leetcode;

import java.util.*;

public class sevenseventhree {
    public static int slidingPuzzle(int[][] board) {
        ArrayList<ArrayList<Integer>> soli = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);row1.add(2);row1.add(3);
        soli.add(row1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);row2.add(5);row2.add(0);
        soli.add(row2);
        ArrayList<ArrayList<Integer>> boar = new ArrayList<>();
        ArrayList<Integer> rows1 = new ArrayList<>();
        rows1.add(board[0][0]);rows1.add(board[0][1]);rows1.add(board[0][2]);
        boar.add(rows1);
        ArrayList<Integer> rows2 = new ArrayList<>();
        rows2.add(board[1][0]);rows2.add(board[1][1]);rows2.add(board[1][2]);
        boar.add(rows2);
        Queue<ArrayList<ArrayList<Integer>>> queue = new LinkedList<>();
        Set<ArrayList<ArrayList<Integer>>> all = new HashSet<>();
        all.add(boar);
        queue.add(boar);
        int ans =0;
        while (!queue.isEmpty()){
            int z = queue.size();
            for (int i = 0; i <z ; i++) {
                ArrayList<ArrayList<Integer>> temp = queue.remove();
                if(temp.equals(soli)){return ans;}
                ArrayList<ArrayList<ArrayList<Integer>>> shifted = shift(temp);
                for (ArrayList<ArrayList<Integer>> ints : shifted) {
                    if (all.add(ints)) {
                        queue.add(ints);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    public static ArrayList<ArrayList<ArrayList<Integer>>> shift(ArrayList<ArrayList<Integer>> board){
        ArrayList<ArrayList<ArrayList<Integer>>> ans = new ArrayList<>();
        for (int i = 0; i < board.size() ; i++) {
            for (int j = 0; j < board.get(i).size() ; j++) {
                if (board.get(i).get(j)==0){
                    ArrayList<ArrayList<Integer>> up = new ArrayList<>();
                        makecopy(up,board);
                        int temp = up.get(1).get(j);
                        up.get(1).set(j,up.get(0).get(j));
                        up.get(0).set(j,temp);
                        ans.add(up);
                        if(j==0){
                            ArrayList<ArrayList<Integer>> right = new ArrayList<>();
                            makecopy(right,board);
                            int tempo = right.get(i).get(j+1);
                            right.get(i).set(j+1,right.get(i).get(j));
                            right.get(i).set(j,tempo);
                            ans.add(right);
                        } else if (j==2) {
                            ArrayList<ArrayList<Integer>> left = new ArrayList<>();
                            makecopy(left,board);
                            int tempo = left.get(i).get(j-1);
                            left.get(i).set(j-1,left.get(i).get(j));
                            left.get(i).set(j,tempo);
                            ans.add(left);
                        }else{
                            ArrayList<ArrayList<Integer>> right = new ArrayList<>();
                            makecopy(right,board);
                            int tempo = right.get(i).get(j+1);
                            right.get(i).set(j+1,right.get(i).get(j));
                            right.get(i).set(j,tempo);
                            ans.add(right);
                            ArrayList<ArrayList<Integer>> left = new ArrayList<>();
                            makecopy(left,board);
                            int tempe = left.get(i).get(j-1);
                            left.get(i).set(j-1,left.get(i).get(j));
                            left.get(i).set(j,tempe);
                            ans.add(left);
                        }

                return ans;}
            }
        }
        return ans;
    }

    private static void makecopy(ArrayList<ArrayList<Integer>> up, ArrayList<ArrayList<Integer>> board) {
        for (ArrayList<Integer> integers : board) {
            ArrayList<Integer> row = new ArrayList<>(integers);
            up.add(row);
        }
    }

    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{{4,1,2},{5,0,3}}));
    }
}
