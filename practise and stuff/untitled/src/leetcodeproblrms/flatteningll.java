package leetcodeproblrms;

import java.util.*;

public class flatteningll {
    class Node{
        int data;
        int val;
        Node random;
        Node next;
        Node bottom;

        Node(int x){
            data=x;
            val=x;
            next=null;
            random=null;
            bottom=null;
        }

    }
    Node flatten(Node root) {
        ArrayList<Node> arr = new ArrayList<Node>();
        Node temp = root;
        while(temp!=null){
            Node tempo = temp;
            while(tempo!=null){
                arr.add(tempo);
                tempo=tempo.bottom;
            }
            temp= temp.next;
        }
        arr.sort(Comparator.comparingInt(a -> a.data));
        Node res = new Node(0);
        Node demo = res;
        for (Node n :arr ){
            demo.next=n;
            demo= demo.next;
        }
        return res.next;
    }
    public Node copyRandomList(Node head) {
        Node demon= head;
        Map<Node,Integer> og = new HashMap<>();
        og.put(null,-1);
        Node copy = new Node(0);
        Node demo = copy;
        Map<Integer,Node> nog= new HashMap<>();
        nog.put(-1,null);
        int i=0;
        while(demon!=null){
            og.put(demon,i);
            demo.next=new Node(demon.val);
            demo=demo.next;
            nog.put(i,demo);
            i++;
            demon=demon.next;
        }
        demon=head;
        demo=copy.next;
        while(demo!=null){
            int n = og.get(demon.random);
            demo.random=nog.get(n);
            demo=demo.next;
            demon=demon.next;
        }
        return copy.next;
    }
}
