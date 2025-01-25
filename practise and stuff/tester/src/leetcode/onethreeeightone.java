package leetcode;

import java.util.ArrayList;

public class onethreeeightone {
    class CustomStack {
        ArrayList<Integer> list;
        int k;
        public CustomStack(int maxSize) {
            this.list= new ArrayList<>();
            this.k=maxSize;
        }

        public void push(int x) {
            if(k!=0){
            list.addFirst(x);}
        }

        public int pop() {
            if(list.isEmpty()){return -1;}
            else{k++;return list.removeFirst();}
        }

        public void increment(int k, int val) {
            int j = list.size()-1;
            for (int i =0; i<k&&j>=0 ; i++) {
              list.set(j,list.get(j)+k);
              j--;
            }
        }
    }
}
