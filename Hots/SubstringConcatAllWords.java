import java.util.*;

class Solution {
	public boolean checkStartPoint(int sp,int ep,String s,HashMap<String,Integer> hm,int len){
		HashMap<String,Integer> curr = new HashMap<>();
		curr.putAll(hm);
		while(sp<ep && curr.size()>0){
			String currSubstring = s.substring(sp,sp+len);
			// System.out.println(currSubstring);
			if(!curr.containsKey(currSubstring)) return false;
			curr.put(currSubstring,curr.get(currSubstring) - 1);
			if(curr.get(currSubstring) == 0) curr.remove(currSubstring);
			sp+=len;
		}
		return true;
	}
    public List<Integer> findSubstring(String s, String[] words) {
        // write code here
		List<Integer> res= new ArrayList<>();
		int wlen  = words[0].length();
		int total = words.length;
		int wordWindow = wlen*total;
		
		HashMap<String,Integer> hm= new HashMap<>();
		for(String ss: words){
			hm.put(ss,hm.getOrDefault(ss,0)+1);
		}

		int i = 0;
		while(i+wordWindow<=s.length()){
			if(checkStartPoint(i,i+wordWindow,s,hm,wlen)){
				res.add(i);
			}
			i++;
		}
		return res;
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}
