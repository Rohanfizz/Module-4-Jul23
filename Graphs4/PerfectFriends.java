import java.io.*;
import java.util.*;
  class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
class Solution{

	public static int calcSize(ArrayList<Edge>[] graph,int node,boolean[] vis){
		vis[node] = true;
		int mySize = 1;
		for(Edge e: graph[node]){
			int nbr  = e.nbr;
			if(!vis[nbr]) mySize += calcSize(graph,nbr,vis);
		}
		return mySize;
	}
	
    public static int perfectStudents(int V,  ArrayList<Edge>[] graph){
       // Your code here
		boolean[] vis  = new boolean[V];
		ArrayList<Integer> compoSize = new  ArrayList<>();

		for(int i = 0;i<V;i++){
			if(vis[i]) continue;
			int size = calcSize(graph,i,vis);
			compoSize.add(size);
		}
		int ans  = 0;
		for(int i = 0;i<compoSize.size();i++){
			for(int j = i+1;j<compoSize.size();j++) ans += compoSize.get(i) * compoSize.get(j);
		}
		return ans;
   }
}
public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      int vtces = n;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = k;
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
      System.out.println(Solution.perfectStudents(n, graph));
   }

}