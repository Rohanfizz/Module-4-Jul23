package TwoPointersSlidingWindow2;
import java.io.*;
import java.util.*;

class Solution {
	public boolean areMatching(HashMap<Character,Integer> curr, HashMap<Character,Integer> ideal){
		for(char c: ideal.keySet()){
			if(!curr.containsKey(c)) return false;
			if(curr.get(c) < ideal.get(c)) return false;
		}
		return true;
	}
    public String minWindow(String s, String t) {
		// write code here
		int sp =0;
		int ep = 0;

		int len = Integer.MAX_VALUE;
		String ans = "";

		HashMap<Character,Integer> ideal  = new HashMap<>();
		HashMap<Character,Integer> curr  = new HashMap<>();

		//fill the ideal hashmap first
		for(int i = 0;i<t.length();i++){
			char ch = t.charAt(i);
			ideal.put( ch , ideal.getOrDefault(ch,0) + 1 );
		}

		//ill have to start the sliding window
		while(ep<s.length()){
			//introduce
			char cep = s.charAt(ep);
			curr.put(cep,curr.getOrDefault(cep,0) + 1); //incrementing the freq of character at ep

			//shrink until valid
			while(areMatching(curr,ideal)){
				//consider the curr window for answer
				if(ep-sp+1 < len){
					len = ep-sp+1;
					ans = s.substring(sp,ep+1);
				}
				//shrink
				char csp = s.charAt(sp);
				curr.put(csp,curr.get(csp)-1); //decrementing the freq of char at sp
				sp++;
			}

			//expand 
			ep++;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}