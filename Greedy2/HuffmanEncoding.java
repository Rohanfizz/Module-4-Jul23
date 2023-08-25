import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution {
	public  class Node{
		char data;
		int freq;
		Node left;
		Node  right;
		Node(char data,int freq){
			this.data =data;
			this.freq = freq;
			this.left = null;
			this.right = null;
		}
	}
    public ArrayList<String> huffmanCodes(String S, int f[], int N){
        // Code here
		PriorityQueue<Node> pq = new  PriorityQueue<>((a,b)->{
			// return a.freq-b.freq;
			return a.freq < b.freq ? -1 : 1; //portal magic
		});
		//Add all the characters with their freq in the form of node in pq
		for(int i = 0;i<N;i++){
			pq.add(new Node(S.charAt(i),f[i]));
		}
        //Now i have added all the characters,
		//its time to form huffmanTree
		while(pq.size() > 1){
			Node a = pq.remove();//a will be having smaller freq as its coming out of the pq earlier than b
			Node b = pq.remove();

			Node nn = new Node('*',a.freq + b.freq);
			nn.left = a;
			nn.right = b;

			pq.add(nn);
		}
		//the above loop will get over when ill only be having 1 node in the pq
		//and that 1 node will be the root of my huffman tree
		Node root = pq.remove();

		//perform simple dfs and fill the codes
		ArrayList<String> ans = new ArrayList<>();
		dfs(root,ans,"");
		return ans;
    }

	public static void dfs(Node node,ArrayList<String> ans,String psf){
		if(node.left == null && node.right == null){
			//I am standing on a leaf node
			//and in an huffman tree leaf node represents a char
			ans.add(psf);
			return;
		}
		
		dfs(node.left,ans,psf+"0");
		dfs(node.right,ans,psf+"1");
	}
	
}









