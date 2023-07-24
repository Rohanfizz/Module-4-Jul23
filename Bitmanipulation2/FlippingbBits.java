import java.util.*;
import java.io.*;

class Solution {
    public long flipBits(long n) {
        // your code here
		long bitmask = ((long)1<<32) - 1;
		return n^bitmask;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        Solution solution = new Solution();
        for(int qq = 0; qq < q; qq++){
            long n = input.nextLong();
            System.out.println(solution.flipBits(n));
        }
    }
}