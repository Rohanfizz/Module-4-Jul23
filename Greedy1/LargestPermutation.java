import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static int[] largestPermutation(int[] A, int b) {
        //Write your code here
		int N = A.length;
		int[] index = new int[N+1];

		for(int i = 0;i<N;i++) index[A[i]] = i;

		int i = 0;
		while(i<N && b>0){
			int ideal = N-i;
			if(ideal == A[i]){
				i++;
				continue;
			}
			b--;
			int indexOfIdeal = index[ideal];
			int currVal = A[i];
			//swapping begins
			A[i] = ideal;
			A[indexOfIdeal] = currVal;
			index[currVal] = indexOfIdeal;
			index[ideal] = i;
			i++;
		}
		return A;
        
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = sc.nextInt();

        int b =sc.nextInt();
        Solution obj= new Solution();
        int [] ans = obj.largestPermutation(A, b);

        for(int i=0;i<n;i++)
            System.out.print(ans[i]+" ");
    }
}