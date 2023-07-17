package TwoPointersSlidingWindow2;
import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        // write code here
		//this problem is having a constant window size
		int sp =0;
		int ep = 0;
		int[] res = new int[N-K+1]; //number of windows of length k = n-k+1
		Deque<Integer> dq = new LinkedList<>();
		//Since the window Size is constant, i have  to preCalculate the  answer 
		//for the first window
		while(ep<K){
			//add this person in dq
			while(dq.size() > 0 && arr[dq.getLast()] < arr[ep]) dq.removeLast();//removing people from the back until all the people are smaller than me
			dq.addLast(ep);//adding the index
			ep++;
		}
		res[0] = arr[dq.getFirst()];//the person in front of dq;
		int win = 1;//represents the next window for which we have to calculate the answer
		while(ep<N){
			//add the ep'th person in dq
			while(dq.size() > 0 && arr[dq.getLast()] < arr[ep]) dq.removeLast();//removing people from the back until all the people are smaller than me
			dq.addLast(ep);//adding the index
			sp++;
			//find answer for this window
			//it is possible that person in front might not belong to the curr window
			while(dq.getFirst() < sp) dq.removeFirst();
			//after removing all the out of bounds people, the person standing in the front will be answer for the curr window
			res[win] = arr[dq.getFirst()];
			ep++;
			win++;
		}
		return res;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
