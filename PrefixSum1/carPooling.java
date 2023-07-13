
 import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution{
  
    public boolean carPooling(int[][] trips, int capacity) {
		//your 
		// TC,SC : O(N)
		int[] prefStep = new int[1001];
		
		for(int[] trip:trips){
			int numPass = trip[0];
			int source = trip[1];
			int destination = trip[2];
			prefStep[source] += numPass;
			prefStep[destination] -= numPass;
		}

		//now i will take the prefix sum of the pref step array
		for(int i = 1;i<1001;i++){
			prefStep[i] += prefStep[i-1];
		}
		//now check if we exceed the number of passengers on any station
		for(int x: prefStep) if(x > capacity) return false;
		return true;
	}
}







