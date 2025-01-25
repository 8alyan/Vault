package leetcodeproblrms;

import java.util.*;

public class aliendick {
    public static String findOrder(String [] dict, int N, int K) {
        StringBuilder ans = new StringBuilder();
        ArrayList<Integer>[] edges = new ArrayList[K];
        for (int i = 0; i <K ; i++) {
            edges[i]= new ArrayList<>();
        }
        Stack<Integer> sd = new Stack<>();
        int[] indegree = new int[K];
        for (int i = 0; i <N-1 ; i++) {
            String a = dict[i];
            String b = dict[i+1];
            int p =0;
            int l = Math.min(a.length(),b.length());
            while (p<l&&a.charAt(p)==b.charAt(p)){p++;}
            if (p==l){continue;}
            edges[(int)a.charAt(p)-'a'].add((int) b.charAt(p)-'a');
            indegree[(int)b.charAt(p)-'a']++;
        }
        for (int i = 0; i <K; i++) {
            if (indegree[i]==0){sd.add(i);}
        }
        while(!sd.isEmpty()){
            int s = sd.pop();
            ans.append((char)('a'+s));
            for (int i = 0; i <edges[s].size() ; i++) {
                int d = edges[s].get(i);
                indegree[d]--;
                if (indegree[d]==0){sd.add(d);}
            }

        }
        return ans.toString();


    }
    class pair{
        int d ;
        int lagat;

        pair(int d, int laga){
            this.d=d;
            this.lagat=laga;
        }
    }

    public static int[] shortestPath(int N,int M, int[][] edges) {
        int[] ans = new int[N];
        int[] in = new int[N];
        Arrays.fill(ans,-1);
        ans[0]=0;
        ArrayList<int[]>[] edge = new ArrayList[N];
        for (int i = 0; i <N ; i++) {
            edge[i]= new ArrayList<>();
        }
        for (int[] pair : edges){
            edge[pair[0]].add(new int[]{pair[1],pair[2]});
            in[pair[1]]++;
        }
        Stack<Integer> sd = new Stack<>();
        for (int i = 0; i <N ; i++) {
            if (in[i]==0){sd.add(i);}
        }
        while(!sd.isEmpty()){
            int s = sd.pop();
            for (int i = 0; i <edge[s].size() ; i++) {
                int d = edge[s].get(i)[0];
                int laga = edge[s].get(i)[1]+ans[s];
                in[d]--;
                if (in[d]==0){sd.add(d);}
                if (ans[s]==-1){continue;}
                if (ans[d]==-1){ans[d]=laga;}
                else{
                    ans[d]=Math.min(ans[d],laga);}


            }

        }

        return ans;

    }
    public static String twozerozerozero(String word,char ch){
        StringBuilder ans = new StringBuilder();
        int b = word.indexOf(ch);
        if (b==-1){return word;}
        String r = word.substring(0,b+1);
        ans.append(r);
        ans.reverse();
        ans.append(word.substring(b+1));
        return ans.toString();
    }
    public static int twofourfourone(int[] nums){
        int m =0;
        for (int n :nums){
            m=Math.max(n,m);
        }
        int[] ans = new int[2*m+1];
        for (int n:nums){
            if (m<Math.abs(n)){continue;}
            ans[m+n]++;
        }
       int l =0;
       int r = ans.length-1;
       while(r>l){
           if (ans[l]==ans[r]){return r-m;}
           r--;
           l++;
       }
       return -1;
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        int i = 0;
        int j =0;
        while(i<v1.length&&j<v2.length){
            if (Integer.parseInt(v1[i])!=Integer.parseInt(v2[j])){
                return Integer.parseInt(v1[i])>Integer.parseInt(v2[j]) ? 1:-1;
            }
            i++;j++;
        }
        while (i<v1.length){
            if (Integer.parseInt(v1[i])>0){return 1;}
            i++;
        }
        while (j<v2.length){
            if (Integer.parseInt(v2[j])>0){return -1;}
            j++;
        }
        return 0;

    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int tukde=0;
        int csum =0;
        int left =0;
        int right = people.length-1;
        while(right>=left){
            if (right>left&&csum+people[right]<=limit)
            {
                csum+=people[right];
                right--;
            }
            if (left<=right&&csum+people[left]<=limit){
                csum+=people[left];
                left++;
            }
            tukde++;
            csum=0;
        }
        return tukde;

    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[S]=0;
        pq.add(new int[]{S,0});
        while(!pq.isEmpty()){
            int[] pair = pq.remove();
            for (int i = 0; i <adj.get(pair[0]).size() ; i++) {
                int des = adj.get(pair[0]).get(i).get(0);
                int cost = adj.get(pair[0]).get(i).get(1);
                if (dist[des]>dist[pair[0]]+cost){
                    dist[des]=dist[pair[0]]+cost;
                    pq.add(new int[]{des,dist[des]});
                }
            }
        }

        
        return  dist;
    }
    public static List<Integer> shortestPathd(int n, int m, int edges[][]){
       int[] dist = new int[n+1];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[1]=0;
       ArrayList<ArrayList<Integer>> path = new ArrayList<>();
       ArrayList<ArrayList<int[]>> edge = new ArrayList<>();
        for (int i = 0; i <n+1; i++) {
            edge.add(new ArrayList<>());
            path.add(new ArrayList<>());
        }
       for (int[] e:edges){
           edge.get(e[0]).add(new int[]{e[1],e[2]});
           edge.get(e[1]).add(new int[]{e[0],e[2]});
       }
       PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
       pq.add(new int[]{1,0});
       while(!pq.isEmpty()){
           int[] pair = pq.remove();
           for (int i = 0; i <edge.get(pair[0]).size() ; i++) {
               int des = edge.get(pair[0]).get(i)[0];
               int laga = edge.get(pair[0]).get(i)[1];
               if (laga+dist[pair[0]]<dist[des]){
                   dist[des]=laga+dist[pair[0]];
                   pq.add(new int[]{des,dist[des]});
                   ArrayList<Integer> temp = new ArrayList<>(path.get(pair[0]));
                   temp.add(pair[0]);
                   path.set(des,temp);
               }
           }
       }
       path.get(n).add(0,dist[n]==Integer.MAX_VALUE ? -1:dist[n]);
       path.get(n).add(n);
        return path.get(n);
    }



    public static void main(String[] args) {
//        System.out.println(Arrays.toString(shortestPath(10, 24, new int[][]{{0, 2, 6}, {0, 3, 7}, {0, 4, 9}, {0, 6, 8}, {0, 7, 6}, {1, 2, 6}, {1, 3, 7}, {1, 5, 10}, {1, 6, 1}, {1, 7, 4}, {2, 3, 3}, {2, 6, 10}, {2, 8, 8}, {2, 9, 10}, {3, 5, 3}, {3, 6, 10}, {3, 7, 5}, {5, 6, 9}, {5, 7, 7}, {6, 7, 7}, {6, 8, 8}, {6, 9, 8}, {7, 9, 1}, {8, 9, 6}})));
//        System.out.println(compareVersion("1.0.1","1"));
//        System.out.println(numRescueBoats(new int[]{3,2,3,2,2},6));
        System.out.println(shortestPathd(5,6,new int[][]{{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}}));
    }
}
