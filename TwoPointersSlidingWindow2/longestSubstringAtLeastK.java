package TwoPointersSlidingWindow2;
import java.util.*;

class Solution {

	public int longestSubstringHavingXuniqueAtLeatKRep(String s,int k,int x){
		HashMap<Character,Integer> hm = new HashMap<>();
		int sp = 0;
		int ep = 0;

		int ans = 0;

		int numUnique = 0;
		int numRepK = 0;

		while(ep<s.length()){
			//introduce
			char chep = s.charAt(ep);
			hm.put(chep,hm.getOrDefault(chep,0) + 1);//incremented the freq of char at ep

			if(hm.get(chep) == 1) numUnique++;
			if(hm.get(chep) == k) numRepK++;

			//i might have added > x characters, shrink until numUnique > x
			while(numUnique > x){
				char chsp = s.charAt(sp);
				hm.put(chsp,hm.get(chsp) - 1); //decremented the freq of char at sp

				if(hm.get(chsp) == 0) numUnique--;
				if(hm.get(chsp) == k-1) numRepK--;

				sp++;
			}
			//answer consideration
			if(numUnique == x && numRepK == x){
				ans = Math.max(ans,ep-sp+1);
			}
			//expand
			ep++;
		} 
		return ans;
	}
	
    public int longestSubstring(String s, int k) {
        // write code here
		int ans = 0;
		for(int x = 1;x<=26;x++){
			ans = Math.max(ans,longestSubstringHavingXuniqueAtLeatKRep(s,k,x));
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
