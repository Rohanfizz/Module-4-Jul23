import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void destroy(int[][] grid,int i,int j){
		if(i<0 || i==grid.length || j<0 || j==grid[0].length || grid[i][j]==0) return;
		//mark
		grid[i][j] = 0;
		//work
		//visit nbrs
		for(int d= 0;d<4;d++){
			int ni = i+di[d];
			int nj = j+dj[d];
			destroy(grid,ni,nj);
		}
	}

	
  public static int numEnclaves(int[][] grid) {
    // your code here
	  int n = grid.length;
	  int m = grid[0].length;
	  //travel on the zeroth row
	  for(int j = 0;j<m;j++) {
		  if(grid[0][j] == 1) destroy(grid,0,j);
	  }
	  //travel on last row
	  for(int j = 0;j<m;j++){
		  if(grid[n-1][j] == 1) destroy(grid,n-1,j);
	  }
	  //travel on first  col
	  for(int i = 0;i<n;i++){
		  if(grid[i][0] == 1) destroy(grid,i,0);
	  }
	  //travel on last  col
	  for(int i = 0;i<n;i++){
		  if(grid[i][m-1] == 1) destroy(grid,i,m-1);
	  }
		int ans = 0;
	  for(int i = 0;i<n;i++){
		  for(int j = 0;j<m;j++){
			  if(grid[i][j] == 1)  ans++; //counting land cells which are still alive
		  }
	  }
	  return ans;
  }
}











