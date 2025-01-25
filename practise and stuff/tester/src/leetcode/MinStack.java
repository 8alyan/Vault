package leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

class MinStack {
    PriorityQueue<Integer> queue;
    ArrayList<Integer> list;

    public MinStack() {
     queue= new PriorityQueue<>();
       list=new ArrayList<>();
    }

    public void push(int val) {
        queue.add(val);
        list.addFirst(val);
    }

    public void pop() {
        queue.remove(list.removeFirst());
    }

    public int top() {
        return list.getFirst();
    }

    public int getMin() {
        return queue.peek();
    }
}
