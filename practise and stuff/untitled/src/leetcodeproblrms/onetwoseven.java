package leetcodeproblrms;

import java.util.*;

public class onetwoseven {
    public  static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,Boolean> fg = new HashMap<>();
        for (String h:wordList){
            fg.put(h,false);
        }
        fg.put(beginWord,false);
        if (!fg.containsKey(endWord)){return -1;}
        int level = -1;
        Queue<String> sd = new LinkedList<>();
        sd.add(beginWord);
        while(!sd.isEmpty()){
            int size = sd.size();
            level++;
            for (int i = 0; i <size ; i++) {
            String d = sd.remove();
            if (d.equals(endWord)){return level;}
            if (!fg.get(d)){
                fg.put(d,true);
                for (int k = 0; k <d.length(); k++) {
                    StringBuilder df = new StringBuilder();
                    df.append(d, 0, k);
                    for (int j = 0; j<26; j++) {
                        StringBuilder dff = new StringBuilder(df);
                        dff.append((char)('a'+j));
                        dff.append(d, k +1,d.length());
                        if (fg.containsKey(dff.toString())&&!fg.get(dff.toString())){
                            sd.add(dff.toString());
                        }

                    }
                }
            }}

        }
 return 0;
    }
    class pair{
        String a ;
        ArrayList<String> b;
        pair(String a,ArrayList<String> b){
            this.a =a;
            this.b= b;
        }
    }

    public  List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Map<String,Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        map.put(beginWord,0);
        if (!set.contains(endWord)){return null;}
        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            for (int k = 0; k <size; k++) {
                String pop = queue.remove();
                if (pop.equals(endWord)){break;}
                char[] cr = pop.toCharArray();
                for (int i = 0; i <pop.length() ; i++) {
                    char og = cr[i];
                    for (char j = 'a'; j <='z' ; j++) {
                        cr[i]=j;
                        String diff = new String(cr);
                        if (set.contains(diff)){
                            set.remove(diff);
                            queue.add(diff);
                            map.put(diff,level);
                        }
                    }
                    cr[i]=og;
                }
            }
        }
        if (map.size()==1||!map.containsKey(endWord)){return new ArrayList<>();}
      dfsss(map,map.get(endWord),endWord,new ArrayList<>());
        return ans;
    }
    List<List<String>> ans = new ArrayList<>();

    private void dfsss(Map<String, Integer> map,int level,String endWord,ArrayList<String> seq) {
        seq.addFirst(endWord);
        if (level==0){
            ArrayList<String> temp=new ArrayList<>(seq);
            ans.add(temp);return;}
        Set<String> set = map.keySet();
        char[] cr = endWord.toCharArray();
        for (int i = 0; i <endWord.length(); i++) {
            char og = cr[i];
            for (char j = 'a'; j <='z'; j++) {
                cr[i]=j;
                String newb = new String(cr);
                if (set.contains(newb)&&map.get(newb)==level-1){
                    dfsss(map,level-1,newb,seq);
                    seq.remove(0);
                }
            }
            cr[i]=og;
        }
    }

    public static void main(String[] args) {
        List<String> sd = new ArrayList<>();
        sd.add("hot");
        sd.add("cog");
        sd.add("dot");
        sd.add("tog");
//        sd.add("hog");
//        sd.add("hop");
//        sd.add("pot");
//        sd.add("dot");

        onetwoseven s = new onetwoseven();
        for (List<String> df : s.findLadders("hit","cog",sd)){
            System.out.println(df.toString());
        }
    }
}
