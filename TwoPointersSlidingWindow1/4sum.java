class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        int i = 0;
        while(i<n){
            int j = i+1;
            while(j<n){
                //i have selected ith and jth person,
                //find 2 people summing up to a new target
                long newTarget = (long)(target - ((long)nums[i] + (long)nums[j]));
                //implement 2sum for rest the array
                int l = j+1;
                int r = n-1;
                while(l<r){
                    long csum = (long)((long)nums[l] + (long)nums[r]);
                    if(csum == newTarget){
                        List<Integer> cres = new  ArrayList<>();
                        cres.add(nums[i]);
                        cres.add(nums[j]);
                        cres.add(nums[l]);
                        cres.add(nums[r]);
                        res.add(cres);
                        
                        int prevL = nums[l];
                        while(l<r && nums[l] == prevL) l++;
                        
                        int prevR =nums[r];
                        while(r>l && nums[r] == prevR) r--;

                    }else if(csum <newTarget){
                        int prevL = nums[l];
                        while(l<r && nums[l] == prevL) l++;
                    }else{
                        int prevR =nums[r];
                        while(r>l && nums[r] == prevR) r--;
                    }
                }
                int prevJ = nums[j];
                while(j<n && nums[j] == prevJ) j++;
            }
            int prevI = nums[i];
            while(i<n && nums[i] == prevI) i++;
        }
        return res;
    }
}