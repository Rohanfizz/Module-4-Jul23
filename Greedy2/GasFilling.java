import java.util.*;

class Solution {
    
    public int filling(int gas[],int cost[],int n) {
        //Write your code here
		int totalGas =0;
		int totalCost = 0;
		for(int i = 0;i<n;i++){
			totalGas += gas[i];
			totalCost += cost[i];
		}
		if(totalGas < totalCost){
			//No starting point is possible
			return -1;
		}
		//If  im standing on this line of code
		//answer is possible

		int tank = 0;
		int asp= -1;

		for(int i = 0;i<n;i++){
			tank += gas[i];
			tank -= cost[i];

			if(tank < 0){
				tank = 0;
				asp = -1;
			}else{
				if(asp == -1) asp = i;
			}
		}
		return asp;
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}
