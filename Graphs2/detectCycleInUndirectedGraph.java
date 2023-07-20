import java.io.*;
import java.util.*;

class Solution {

	public static boolean bfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int src){
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		while(q.size()>0){
			//Remove
			int cNode = q.remove();
			//mark
			if(vis[cNode]) return true; // we are visiting sm1 for the second time, hence the cycle has been detected
			vis[cNode] = true;
			//work - dont have any work for this question
			//Add unvisited nbrs
			for( int nbr : graph.get(cNode)){
				if(!vis[nbr]) q.add(nbr);
			}
		}
		return false;
	}
	
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
       // Your code here
		boolean[] vis = new boolean[V];
		for(int i = 0;i<V;i++){
			//i will try to make ith node as the source node
			if(vis[i]) continue; // this means that ith node has already been covered in some previous bfs
			boolean isCyclic = bfs(graph,vis,i);
			if(isCyclic) return true;
		}
		return false;
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}