import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        Solution s = new Solution();
        String order = s.findOrder(words);
        if(order.equals("-1")){
            System.out.println(-1);
        }
        else if(order.length() == 0){
            System.out.print(0);
        }else{
        String[] temp = new String[n];
         for(int i = 0 ; i < n ; ++i){
             temp[i] = words[i];
         }
         Arrays.sort(temp, new Comparator<String>(){
             @Override
             public int compare(String a , String b){
                 int index1 = 0 ; 
                 int index2 = 0 ; 
                 for(int i = 0 ; i < Math.min(a.length(),b.length()) && index1==index2;i++){
                     index1 = order.indexOf(a.charAt(i));
                     index2 = order.indexOf(b.charAt(i));

                 }
                 if(index2 == index1 && a.length()!=b.length()){
                     if(a.length() < b.length()){
                         return -1 ; 
                     }else{
                         return 1 ; 
                     }

                 }
                 if(index1 < index2){
                     return -1 ; 
                 }else{
                     return 1 ; 
                 }
             }
         });
         int flag = 1 ; 
         for(int i = 0 ; i < n ; ++i){
             if(!words[i].equals(temp[i])){
                 flag = 0 ; 
                 break  ;
             }
         }
         System.out.print(flag);

        }

    }
}
class Solution{
    public static String findOrder(String [] words){
        //Write your code here 
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i= 0;i<26;i++){
			graph.add(new ArrayList<>());
		}
		int[] indegree = new int[26];
		for(int i = 0;i+1<words.length;i++){
			String a = words[i];
			String b = words[i+1];
			int l = 0;
			int r = 0;
			while(l<a.length() && r<b.length()){
				if(a.charAt(l) != b.charAt(r)){
					int u = a.charAt(r)-'a';
					int v = b.charAt(r)-'a';
					graph.get(u).add(v);
					indegree[v]++;
					break;
				}
				l++;
				r++;
			}
		}
		ArrayList<Integer> topo =new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0;i<26;i++) if(indegree[i] == 0)  q.add(i);

		while(q.size() > 0){
			int curr = q.remove();
			topo.add(curr);
			for(int nbr:  graph.get(curr)){
				indegree[nbr]--;
				if(indegree[nbr] ==0) q.add(nbr);
			}
		}
		String res = "";
		for(int x: topo){
			res+= (char)(x + 'a');
		}
		return res;
		
    }
}









