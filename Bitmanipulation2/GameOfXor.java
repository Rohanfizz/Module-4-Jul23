import java.util.*;
class Solution
{
   static int xorSubarrayXors(int arr[], int n) {
	//Write code here
	   //Tc: O(n)
	   //Sc: O(1)
		int res = 0;
	   for(int i = 0;i<n;i++){
		   int numberOfStartingPoints = (i+1);
		   int numberOfEndingPoints = (n-i);
		   int freq = numberOfStartingPoints * numberOfEndingPoints;
		   if(freq%2==1) res ^= arr[i];//only if the ith person comes odd number of times, i will consider it in my result
	   }
	   return res;
	}
}
public class Main {

    

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int ans = Solution.xorSubarrayXors(arr, n);
        System.out.print(ans);
        input.close();
    }
}