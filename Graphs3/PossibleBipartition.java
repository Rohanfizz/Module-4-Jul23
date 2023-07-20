import java.util.*;

class Solution {
	public class Pair{
		int node;
		int color;
		Pair(int node,int color){
			this.node = node;
			this.color= color;
		}
	}
   public boolean bfs(ArrayList<ArrayList<Integer>> graph,int[] vis,int src){
	   //vis[i] == 0 -> unvisited
	   //vis[i] == 1 -> blue
	   //vis[i] == -1 -> red
	   Queue<Pair> q = new LinkedList<>();
	   q.add(new Pair(src,1));
	   while(q.size()>0){
		   //remove
		   Pair curr = q.remove();
		   //mark
		   if(vis[curr.node] != 0) continue;
		   vis[curr.node] = curr.color;
		   //work
		   //add nbs
		   int opColor = curr.color == 1 ? -1 : 1;
		   for(int nbr: graph.get(curr.node)){
			   if(vis[nbr] == 0){
				   q.add(new Pair(nbr,opColor));
			   }else if(vis[nbr] == curr.color) return false;
		   }
	   }
	   return true;
   }
    public int possibleBipartition(int n, int[][] edges) {
        // Write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i =  0;i<=n;i++){//n+1 arraylists are added to handle 1 based indexing
			graph.add(new  ArrayList<Integer>());
		}
		//add edges
		for(int[] edge: edges){
			int u =edge[0];
			int v = edge[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		int[] vis = new int[n+1];
		for(int i = 1;i<=n;i++){//handling components
			if(vis[i] != 0)  continue;
			boolean isBipartate = bfs(graph,vis,i);
			if(!isBipartate) return 0;
		}
		return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}