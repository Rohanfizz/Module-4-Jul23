import java.util.*;

class Solution {
 
    // @SuppressWarnings("unchecked")
    
    public int[] canFinish(int n, int[][] prerequisites) {
    //Write your code here
		ArrayList<ArrayList<Integer>>  graph  = new ArrayList<>();
		for(int i = 0;i<n;i++){
			graph.add(new ArrayList<>());
		}
		//step1: create indegree array
		int[] indegree= new int[n];
		for(int[] edge: prerequisites){
			int ai = edge[0];
			int bi = edge[1];
			graph.get(bi).add(ai);//bi->ai
			indegree[ai]++;
		}
		Queue<Integer> q = new LinkedList<>();
		//step 2: add all nodes whose indegree is 0 inside the q
		for(int i =0;i<n;i++){
			if(indegree[i] == 0) q.add(i);
		}
		//step 3: start bfs
		ArrayList<Integer> topo = new ArrayList<>();
		while(q.size()>0){
			//remove
			int curr = q.remove();
			//mark
			//work
			topo.add(curr);
			//reduce the indegree of nbrs, and add if nbr indegree == 0
			for(int nbr:graph.get(curr)){
				indegree[nbr]--;
				if(indegree[nbr] == 0) q.add(nbr);
			}
		}
		if(topo.size() < n) return new int[0]; //we are having a cycle in directed graph so no topoligical order is possible
		//converting arraylist to array
		int[] res = new int[n];
		for(int i = 0;i<n;i++){
			res[i] = topo.get(i);
		}
		return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}