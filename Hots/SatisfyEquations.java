import java.io.*;
import java.util.*;
class Solution{

	public static void dfs(ArrayList<ArrayList<Integer>> graph,int node,int compNo,int[] vis){
		vis[node] = compNo;
		for(int nbr: graph.get(node)){
			if(vis[nbr]==0) dfs(graph,nbr,compNo,vis);
		}
	}
	
    public static boolean equationsPossible(String[] equations) {
        //write your code here 

		//first ill  create a graph, and add edge for every ==
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i= 0;i<26;i++) graph.add(new ArrayList<>());
		for(String e: equations){
			if(e.charAt(1) =='='){
				int u = e.charAt(0)-'a';
				int v = e.charAt(3)-'a';
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
		}
		//mark all the components
		int[] vis = new int[26];
		int compNo = 1;
		for(int i = 0;i<26;i++){
			if(vis[i]!=0) continue;
			dfs(graph,i,compNo,vis);
			compNo++;
		}
		//every equation to verify != signs
		for(String e: equations){
			if(e.charAt(1) =='!'){
				int u = e.charAt(0) - 'a';
				int v = e.charAt(3)-'a';
				if(vis[u] == vis[v]) return false;
			}
		}
		// for(int x: vis){
		// 	System.out.print(x+" ");
		// }
		return true;
		
		
  }
}
public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      arr[i] = br.readLine();
    }
Solution ob = new Solution();
    System.out.println(ob.equationsPossible(arr));
  }

  
}