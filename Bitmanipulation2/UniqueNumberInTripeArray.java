import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static boolean checkIthBitSet(int n,int i){
		return (n & (1<<i)) != 0;
	}
    public static int singleNumber(int[] nums) {
    // Your code here
		int[] bitFreq = new int[32];
		for(int x: nums){
			for(int i = 0;i<32;i++){
				if(checkIthBitSet(x,i)) bitFreq[i]++;
			}
		}
		//after the above loop, bitfreq[i] will tell me how many people are having the ith bit set
		int ans = 0;
		int pow = 1;
		for(int i = 0;i<32;i++){
			if(bitFreq[i] % 3 != 0){//i am having an extra bit here
				ans += pow;
			}
			pow*=2;
		}
		return ans;
	}
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}