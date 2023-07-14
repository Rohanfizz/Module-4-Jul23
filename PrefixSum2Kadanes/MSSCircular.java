class Solution {
    public int maxSubarraySumCircular(int[] arr) {
      int trainMaxi = 0;
			int n = arr.length;
			int maxi = Integer.MIN_VALUE;

			int trainMini = 0;
			int mini = Integer.MAX_VALUE;

			int total = 0;

			for(int i = 0;i<n;i++){
				total += arr[i];

				//maxSum subarray
				int maxNewTrain = arr[i];
				int maxPrevTrain = arr[i] + trainMaxi;
				trainMaxi = Math.max(maxNewTrain,maxPrevTrain);
				maxi = Math.max(maxi,trainMaxi);

				//minSum subarray
				int minNewTrain = arr[i];
				int minPrevTrain = arr[i] + trainMini;
				trainMini = Math.min(minNewTrain,minPrevTrain);
				mini = Math.min(mini,trainMini);
			}

			int wrapAround = total-mini;
			if(total == mini) return maxi;//if all of them are -ve
			return Math.max(wrapAround,maxi);
    }
}