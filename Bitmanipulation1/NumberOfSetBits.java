import java.util.*;

class Solution {
    public int setBits(int n) {
        // write code here
		// int  count = 0;
		// while(n > 0){
		// 	if((n & 1) == 1) count++;
		// 	n>>=1;
		// }
		// return count;
		int count = 0;
		while(n > 0){
			count++;
			n = n&(n-1);
		}
		return count;
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setBits(n));
    }
}