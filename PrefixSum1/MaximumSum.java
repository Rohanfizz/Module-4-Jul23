import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] A, int[][] ops) {
		int n  = A.length;
	    int[] prefStep = new int[n];
		for(int[] op:ops){
			int l = op[0];
			int r = op[1];
			prefStep[l]++;
			if(r+1<n) prefStep[r+1]--;
		}
		//convert prefix step array into prefix sum array
		for(int i= 1;i<n;i++){
			prefStep[i] += prefStep[i-1];
		}

		Arrays.sort(prefStep);
		Arrays.sort(A);

		int  score = 0;
		int md = 1000000007;
		for(int i = 0;i<n;i++){
			score = (score%md +  (A[i] * prefStep[i])%md)%md;
		}
		
		return score%md;
		
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



