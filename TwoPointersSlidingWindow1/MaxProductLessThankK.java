import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Write code here
		int sp = 0;
		int ep = 0;
		int prod = 1;
		int ans = 0;

		while(ep<nums.length){
			//introduce
			prod *= nums[ep];
			//shrink until invalid
			while(prod >= k){
				prod /= nums[sp];
				sp++;
			}
			//update the answer
			ans += ep-sp+1;
			//expand
			ep++;
		}
		return ans;
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
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.numSubarrayProductLessThanK(arr, k);
        System.out.println(result);
        sc.close();
    }
}