import java.util.*;

class Solution {

		public int rangeSum(int[] pref,int l,int r){
			if(l == 0) return pref[r];
			return pref[r] - pref[l-1];
		}
	
        public int[] sumQuery(int[] arr, int[][] queries) {
            // Your code here.
			int[] res = new int[queries.length];

			//step1 : create prefix sum array
			int[] pref = new int[arr.length];
			pref[0] = arr[0];
			for(int i = 1;i<arr.length;i++){
				pref[i] = pref[i-1] + arr[i];
			}
			//step 2: answer  every query using pref array
			for(int q = 0;q<queries.length;q++){
				int l = queries[q][0];
				int r = queries[q][1];
				res[q] = rangeSum(pref,l,r);
			}
			return res;
        }
}

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}