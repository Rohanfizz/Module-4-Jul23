import java.util.*;

class Solution {

	public static void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] visited,int node){
		//mark
		visited[node] = true;
		//work
		System.out.print(node+" ");
		//visit unvisited nbrs
		for(int nbr: graph.get(node)){
			if(visited[nbr] == false){
				//if nbr is  unvisited
				dfs(graph,visited,nbr);
			}
		}
	}
	
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        //Write your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		//i have to add n empty arraylists inside graph
		for(int i = 0;i<n;i++){
			graph.add(new ArrayList<Integer>());
		}
		//its time to add edges
		for(List<Integer> edge: edges){
			int u = edge.get(0);
			int v = edge.get(1);

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		//for the sake of mighty portal
		//we have sort all arraylists in graph
		for(int i =0;i<n;i++) Collections.sort(graph.get(i));
		////////////////////////////////////////////////////////
		boolean[] visited = new boolean[n];
		dfs(graph,visited,0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}