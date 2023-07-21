import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean[] path,ArrayList<Integer> psf,int curr){
		psf.add(curr);//adding curr
		int N = graph.size()-1;
		if(psf.size() == N){
			//we have found a path containing all nodes
			System.out.print(psf);

			boolean cycleFound = false;
			for(int nbr: graph.get(curr)){
				if(nbr == psf.get(0)){
					cycleFound = true;
					break;
				}
			}
			if(cycleFound) System.out.print("(Cycle)");
			System.out.println();
			
			psf.remove(psf.size()-1);//removing curr
			return true;
		}
		//mark
		path[curr]= true;
		//work
		//Nbrs
		for(int nbr: graph.get(curr)){
			if(!path[nbr]){
				boolean pathFound = dfs(graph,path,psf,nbr);
				// if(pathFound) return true;
			}
		}
		//unmark
		path[curr] = false;
		psf.remove(psf.size()-1);//removing curr 
		return false;
	}
	
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
	    ArrayList<ArrayList<Integer>> graph = new  ArrayList<>();
		for(int i =0;i<=N;i++){
			graph.add(new ArrayList<Integer>());
		}
		for(ArrayList<Integer> edge: Edges){
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		boolean[] path = new  boolean[N+1];
		//Consider all nodes as source
		for(int i = 0;i<=N;i++){
			ArrayList<Integer> psf  = new ArrayList<>();
			boolean pathFound = dfs(graph,path,psf,i);
			// if(pathFound) return true;
		}
		return false;
    }
}










