import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k)
    {
        //Write your code here
		int sp = 0;
		int ep = 0;
		int numZeroes = 0; //this stores the number of zeroes in my window
		//or in other words, this is the data about my window, on the basis of which i decide if i want to shrink or expand

		int ans = 0;

		while(ep<n){
			//step1: introduce the new person (arr[ep]) in the window
			if(arr[ep] == 0) numZeroes++;

			//step2: due to the addition of new person, it is possible that my window might have become invalid
			//so i will keep on shrinking until the window have become valid
			while(numZeroes > k){//my window can have number of zeroes<=k
				//shrink
				if(arr[sp] == 0 ) numZeroes--;
				sp++;
			}
			//if im standing on this line of code, this means that the window valid
			//step 3: update ans
			ans = Math.max(ans,ep-sp+1); // ep-sp+1 is the length of the window
			//step 4: expand
			ep++;
		}
		return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}