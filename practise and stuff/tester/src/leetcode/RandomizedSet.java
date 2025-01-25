package leetcode;

import java.util.*;

class RandomizedSet {
    HashMap<Integer,Integer> s;
    int index;

    public RandomizedSet() {
        s=new HashMap<>();
        index=0;
    }

    public boolean insert(int val) {
        if (!s.containsValue(val)){s.put(index,val);index++;return true;}
        else{return false;}
    }

    public boolean remove(int val) {
         if (s.containsValue(val)){
             s.remove(val);
             return true;
         }
         else {return false;}
    }

    public int getRandom() {
        Random r = new Random();
        int m = r.nextInt(index);
        while(!s.containsKey(m)){
            m = r.nextInt(index);
        }
        return s.get(m);
    }

    public static void main(String[] args) {
        RandomizedSet g = new RandomizedSet();
        g.insert(3);
        System.out.println(g.getRandom());
    }
}
