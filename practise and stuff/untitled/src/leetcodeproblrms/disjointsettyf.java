package leetcodeproblrms;
import java.util.*;

class disjointset{
int[] parent;
int[] rank;
int[] size;
disjointset(int n){
    parent = new int[n+1];
    rank= new int[n+1];
    size = new int[n+1];
    Arrays.fill(size,1);
    for (int i = 0; i <n+1 ; i++) {
        parent[i]=i;
    }

}
disjointset(disjointset f){
    this.parent=Arrays.copyOf(f.parent,f.parent.length);
    this.rank=Arrays.copyOf(f.rank,f.rank.length);
    this.size=Arrays.copyOf(f.size,f.size.length);
}
public int getparent(int n){
    if (parent[n]==n){return n;}
    int k = getparent(parent[n]);
    parent[n]=k;
    return k;
}
public void unionbysize(int a , int b ){
    int upa = getparent(a);
    int upb = getparent(b);
    if (upa==upb){return;}
    if (size[upb]>size[upa]){
        size[upb]+=size[upa];
        parent[upa]=upb;
    }else{
        size[upa]+=size[upb];
        parent[upb]=upa;
    }
}
public void unionbyrank(int a , int b ){
    int upa = getparent(a);
    int upb = getparent(b);
    if (upa==upb){return;}
    if (rank[upb]>rank[upa]){
        parent[upa]=upb;
    } else if (rank[upb]<rank[upa]) {
        parent[upb]=upa;
    }else{
        parent[upb]=upa;
        rank[upa]++;
    }
}
}
public class disjointsettyf {

    int spanningTree(int V, int E, List<List<int[]>> adj) {
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i = 0; i <adj.size() ; i++) {
            for (int j = 0; j <adj.get(i).size() ; j++) {
                int s =i;
                int d = adj.get(i).get(j)[0];
                int c = adj.get(i).get(j)[1];
                edges.add(new int[]{s,d,c});
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[2]));
        disjointset s = new disjointset(V);
        int ans =0;
        for (int i = 0; i <edges.size() ; i++) {
            int [] pair = edges.get(i);
            int a = pair[0];
            int b = pair[1];
            if (s.getparent(a)!=s.getparent(b)){
                s.unionbysize(a,b);
                ans+=pair[2];
            }
        }
        return ans;
    }
    public static int findCircleNum(int[][] isConnected) {
        disjointset set  = new disjointset(isConnected.length);
        for (int i = 0; i <isConnected.length ; i++) {
            for (int j = 0; j < isConnected.length ; j++) {
                if (isConnected[i][j]==1&&i!=j){
                    set.unionbysize(i,j);
                }
            }
        }
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i <isConnected.length ; i++) {
            s.add(set.getparent(i));
        }
        return s.size();

    }

    public static int Solve(int n, int[][] edge) {
        disjointset set = new disjointset(n);
        int une =0;
        for (int i = 0; i <edge.length ; i++) {
            int s = edge[i][0];
            int d = edge[i][1];
            if (set.getparent(s)!= set.getparent(d)){
                set.unionbysize(s,d);
            }else {
                une++;
            }
        }
        int p =0;
        for (int i = 0; i <=n-1; i++) {
            if (set.getparent(i)==i){p++;}
        }
        return une>=p-1? p-1:-1;
    }
    public int[] findRedundantConnection(int[][] edges) {
        disjointset set = new disjointset(edges.length);
        int[] extra = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int d = edges[i][1];
            if (set.getparent(s)==set.getparent(d)){extra = edges[i];}
            else{
                set.unionbysize(s,d);
            }
        }
        return extra;
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> id = new HashMap<>();
        disjointset set = new disjointset(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j <accounts.get(i).size() ; j++) {
                String d = accounts.get(i).get(j);
                if (id.containsKey(d)){
                    set.unionbysize(id.get(d),i);
                }else {
                    id.put(d,i);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        int z =0;
        for (int i = 0; i< accounts.size() ; i++) {
            ans.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer> mp:id.entrySet()){
            int up = set.getparent(mp.getValue());
            ans.get(up).add(mp.getKey());
        }
        int zx =0;
        for (int i = 0,m=0; i<ans.size(); i++,m++) {
                String na =accounts.get(m).getFirst();
                Collections.sort(ans.get(i));
                ans.get(i).addFirst(na);
            if (ans.get(i).size()==1){ans.remove(i);i--;}
        }


        return ans;

    }

    public static int numIslands(char[][] grid) {
        int n = grid.length*grid[0].length;
        int z =1;
        disjointset set = new disjointset(n);
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]!='1'){z++;continue;}
                //right

                //left
                if(j<grid[0].length-1&&grid[i][j+1]=='1'){
                    set.unionbysize(z,z+1);
                }
                //up

                //down
                if (i< grid.length-1&&grid[i+1][j]=='1'){
                    set.unionbysize(z,z+ grid[0].length);}
                z++;
            }
        }
        int ans =0;
        int za =1;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if (grid[i][j]=='1'&&set.getparent(za)==za){ans+=set.size[za];}
                za++;
            }
        }
        return ans;

    }

    public  static int MaxConnection(int grid[][]) {
        int n = grid.length*grid[0].length;
        disjointset set = new disjointset(n);
        int z =1;
        for (int i = 0; i <grid.length; i++) {
            for (int j = 0; j<grid[i].length ; j++) {
                if (grid[i][j]!=1){z++;continue;}
                //left
                if (j<grid[0].length-1&&grid[i][j+1]==1){
                    set.unionbysize(z,z+1);
                }
                //down
                if (i<grid.length-1&&grid[i+1][j]==1){
                    set.unionbysize(z,z+grid[0].length);
                }
                z++;
            }
        }
        int ans =0;
        z=1;
        for (int i = 0; i < grid.length; i++) {
            int big =0;
            for (int j = 0; j <grid[0].length; j++) {
                int right =0,left=0,down=0,up=0;
                Set<Integer> upp = new HashSet<>();
                if (grid[i][j]==1){z++;continue;}
                if (j<grid[0].length-1&&grid[i][j+1]==1){
                   int rightup =set.getparent(z+1);
                   upp.add(rightup);
                    right=set.size[rightup];
                }
                //down
                if (i<grid.length-1&&grid[i+1][j]==1){
                  int downup = set.getparent(z+grid[0].length);
                  if (!upp.contains(downup)){
                      upp.add(downup);
                  down = set.size[downup];}
                }

                if (j>0&&grid[i][j-1]==1){
                   int leftup= set.getparent(z-1);
                   if (!upp.contains(leftup)){
                       upp.add(leftup);
                       left=set.size[leftup];
                   }
                }
                //down
                if (i>0&&grid[i-1][j]==1){
                   int downup= set.getparent(z- grid[0].length);
                   if (!upp.contains(downup)){
                       up=set.size[downup];
                   }
                }
                big = up+down+left+right+1;
                z=z+1;
                ans =Math.max(ans,big);

        }

        }
        return ans;
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        disjointset set = new disjointset(n);
        for (int i = 0; i <stones.length ; i++) {
            for (int j = i+1; j <stones.length ; j++) {
                if (stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
                    set.unionbysize(i,j);
                }
            }
        }
        int ans =0;
        int nyare =0;
        for (int i = 0; i <set.size.length ; i++) {
            if (i==set.getparent(i)){
                ans+=set.size[i];
                nyare++;
            }
        }
        return ans-nyare;

    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingDouble(a->(double)a[0]/a[1]));
        int[] ans = new int[]{-1,-1};
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
               ans= new int[]{arr[i],arr[j]};
               q.add(ans);
            }
        }
        List<int[]> df = (ArrayList<int[]>) q.stream().toList();

        return df.get(k);
    }


    public static void main(String[] args) {
    }
}
