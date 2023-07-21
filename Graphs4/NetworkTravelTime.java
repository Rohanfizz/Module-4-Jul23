import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int n,m,k;
      n=sc.nextInt();
      m=sc.nextInt();
      k=sc.nextInt();
      int[][] a= new int[m][3];
      for(int i=0;i<m;i++){
         int u,v,w;
         u=sc.nextInt();
         v=sc.nextInt();
         w=sc.nextInt();
         a[i][0]=u;
         a[i][1]=v;
         a[i][2]=w;   
      }
      Solution ob = new Solution();
      System.out.println(ob.networkDelayTime(a,n,k));
   }
}
class Solution {
	public class Edge{
		int nbr;
		int wt;
		Edge(int nbr,int  wt){
			this.nbr = nbr;
			this.wt  =wt;
		}
	}
	public class Pair{
		int node;
		int wsf;
		Pair(int  node,int wsf){
			this.node  = node;
			this.wsf = wsf;
		}
	}
    public int networkDelayTime(int[][] times, int n, int K) {
		//Write code here
		ArrayList<ArrayList<Edge>> graph  = new ArrayList<>();
		//n+1 arrayslists are added as 1 based indexing
		for(int i= 0;i<=n;i++){
			graph.add(new ArrayList<Edge>());
		}
		//i have to connect the vertices
		for(int[] edge: times){
			int src = edge[0];
			int nbr = edge[1];
			int wt = edge[2];
			graph.get(src).add(new Edge(nbr,wt));
		}
		//start dijkstra
		PriorityQueue<Pair> pq =  new  PriorityQueue<>((a,b)->{
			return a.wsf-b.wsf;
		});
		pq.add(new Pair(K,0));
		int[] vis = new int[n+1];
		Arrays.fill(vis,-1);
		//start bfs
		while(pq.size()>0){
			//remove
			Pair curr = pq.remove();
			//mark
			if(vis[curr.node] != -1) continue;
			vis[curr.node] = curr.wsf;
			//work
			//add nbrs
			for(Edge e: graph.get(curr.node)){
				int nbr = e.nbr;
				int wt = e.wt;
				if(vis[nbr] == -1) pq.add(new Pair(nbr,curr.wsf + wt));
			}
		}
		//select the person having max signal reaching time
		int maxi = 0;
		for(int i =1;i<=n;i++){
			if(vis[i] == -1) return -1;
			maxi  = Math.max(maxi,vis[i]);
		}
		return maxi;
    }
}















