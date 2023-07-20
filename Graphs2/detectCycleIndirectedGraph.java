import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

	public boolean dfs(ArrayList<Integer>[] graph,boolean[] vis,boolean[] path,int node){
		//mark
		vis[node] = true;
		path[node] = true;
		//work-we have no work for this problem
		//call unvisited nbrs
		for(int nbr: graph[node]){
			if(path[nbr] == true) return true;//the snake is cutting itself
			else if(vis[nbr]==true) continue;
			else if(!vis[nbr]){
				boolean isCyclic = dfs(graph,vis,path,nbr);
				if(isCyclic) return true;
			}
		}
		path[node] = false;
		return false;
	}
	
public boolean isCyclic(int V, ArrayList<Integer>[] graph) {
    // Your code here
	boolean[] vis  = new  boolean[V];
	boolean[] path = new boolean[V];

	//consider components
	for(int i = 0;i<V;i++){
		if(vis[i]) continue;
		boolean isCyclic = dfs(graph,vis,path,i);
		if(isCyclic) return true;
	}
	return false;
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}