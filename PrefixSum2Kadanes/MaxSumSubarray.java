import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
	public long maxSubarraySumPrinter(int a[],int n){
        //Write code here
		long train = 0;
		int csp = 0;
		int cep = 0;
		
		long maxi = Long.MIN_VALUE;
		int osp = -1;
		int oep = -1;

		for(int i= 0;i<n;i++){
			long  prev = train + a[i];
			long newTrain = a[i];
			
			if(newTrain > prev){
				csp = i;//since im starting a new train, csp will come to my index
			}

			train = Math.max(newTrain,prev);

			if(train > maxi){
				maxi = train;
				osp = csp;
				oep = cep;
			}
			cep++;
		}

		System.out.println(osp +" "+oep);
		return maxi;	
    }
    public long maxSubarraySum(int a[],int n){
        //Write code here
		long train = 0;
		long maxi = Long.MIN_VALUE;

		for(int i = 0;i<n;i++){
			long newTrain = a[i];
			long prevTrain = train + a[i];
			train = Math.max(newTrain,prevTrain);
			maxi = Math.max(maxi,train);
		}
		return maxi;
    }
}







