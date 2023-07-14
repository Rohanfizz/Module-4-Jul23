import java.util.*;

class Solution {

    public long solve(int arr[][]) {
        // Your code here
		int n = arr[0].length;
        //i want to create a suffix sum for row 0
		for(int i = n-2;i>=0;i--) arr[0][i] += arr[0][i+1];
		//and prefix sum for row 1
		for(int i = 1;i<n;i++) arr[1][i] += arr[1][i-1];

		int ans = Integer.MAX_VALUE;

		for(int i = 0;i<n;i++){
			//if robot 1 switches the row on ith col
			//the 2 options for robot 2 are as follows
			int option1 = i+1==n ? 0 : arr[0][i+1];
			int option2 = i-1<0 ? 0 : arr[1][i-1];
			int robot2 = Math.max(option1,option2);
			ans = Math.min(ans,robot2);
		}
		return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int grid[][]=new int[2][n];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();

        }
        
        Solution obj=new Solution();
        System.out.println(obj.solve(grid));
        sc.close();
    }
}