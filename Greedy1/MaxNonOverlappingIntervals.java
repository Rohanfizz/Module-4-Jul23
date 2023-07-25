import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
		//Sort everything on the basis of sp
		Collections.sort(A,(a,b)->{
			return a.get(0) - b.get(0);
		});
		int psp = -1;
		int pep = -1;
		int cnt = 0;
		
		for(List<Integer> a: A){
			int csp =a.get(0);
			int cep = a.get(1);

			if(pep >= csp){
				//overlapping - we make a choice
				if(cep < pep){
					//choose the curr interval
					pep = cep;
					psp = csp;
				}
			}else{
				//non-overlapping - consider the curr interval as the next interval
				cnt++;
				psp = csp;
				pep = cep;
			}
		}
		return cnt;
	}
	
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
