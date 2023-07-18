import java.util.*;
import java.io.*;
 
class Graph {
    public int vertices;
    public ArrayList<Integer>[] graph;
 
    Graph(int v) {
        this.vertices = v;
        graph = new ArrayList[v];
        
        for (int i = 0; i < v; i++) graph[i] = new ArrayList<Integer>();
    }
 
    void addEdge(int v, int w) {
        graph[v].add(w);
     
    }
 
    void BFS(int x) {
        // your code here
		boolean[] visited = new  boolean[vertices];
		Queue<Integer> q = new  LinkedList<>();
		q.add(x);
		//bfs starts
		while(q.size()>0){
			//Remove
			int curr = q.remove();
			//mark
			if(visited[curr] == true) continue;
			visited[curr] = true;
			//work
			System.out.print(curr+" ");
			//Add unvisited nbrs
			for(int nbr: graph[curr]){//graph is an array of arraylists
				if(!visited[nbr]) q.add(nbr);
			}
		}
    }
}
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(n);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
