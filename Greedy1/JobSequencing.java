import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution{
    int[] solve(Job arr[], int n){
        // Your code here
		//Sort the arr in desc order on the basis of profit
		Arrays.sort(arr,(a,b)->{
			return b.profit - a.profit;
		});

		//Try to do the jobs close to their deadline
		boolean[] vis = new boolean[n+1];
		int profit = 0;
		int cntJobs = 0;
		for(Job j:arr){
			//i have to find a closest available day
			//to the deadline for this job
			for(int i = j.deadline;i>=1;i--){
				if(vis[i] == false){//i found a vaccant day
					vis[i] = true;
					profit += j.profit;
					cntJobs++;
					break;
				}
			}
		}
		int[] res = new int[2];
		res[0] = cntJobs;
		res[1] = profit;
		return res;
		
    }
}










