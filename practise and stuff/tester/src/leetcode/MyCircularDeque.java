package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

class MyCircularDeque {
    int limit;
    ArrayList<Integer> list;

    public MyCircularDeque(int k) {
        this.limit=k;
        list=new ArrayList<>();
    }

    public boolean insertFront(int value) {
        if(limit==0){return false;}
        else{limit--;list.addFirst(value);}
        return true;
    }

    public boolean insertLast(int value) {
        if(limit==0){return false;}
        else{limit--;list.addLast(value);}
        return true;
    }

    public boolean deleteFront() {
        if(list.isEmpty()){return false;}
        else{limit++;list.removeFirst();return true;}
    }

    public boolean deleteLast() {
        if(list.isEmpty()){return false;}
        else{limit++;list.removeLast();return true;}
    }

    public int getFront() {
        if(list.isEmpty()){return -1;}
        else{return list.getFirst();}
    }

    public int getRear() {
        if(list.isEmpty()){return -1;}
        else{return list.getLast();}
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return limit==0;
    }
}
