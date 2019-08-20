import java.util.*;

class Grid{
	static Scanner sc = new Scanner(System.in);
	static int[][] grid={{1,2,3},
					   {4,8,2},
					   {1,5,3}};
	static int[][] dp;
	public static void main(String[] args) {
		dp=new int[3][3];
		System.out.println(bottom_up());

		dp=new int[3][3];
		for(int[] i : dp)
			Arrays.fill(i,-1);
		System.out.println(top_down(2,2));
	}

	static int top_down(int n,int m){
		if(n<0 || m<0)
			return (int)1e9;

		if(n==0 && m==0){
			//System.out.println("Hit "+grid[0][0]);
			return grid[0][0];
		}

		if(dp[n][m]!=-1)
			return dp[n][m];
		//System.out.println(grid[n][m]);
		int q1=top_down(n-1,m)+grid[n][m];
		int q2=top_down(n,m-1)+grid[n][m];

		dp[n][m]=Math.min(q1, q2);
		//System.out.println(dp[n][m]);

		return dp[n][m];
	}

	static int bottom_up(){

		dp[0][0]=grid[0][0];

		for(int c=1;c<3;c++)
			dp[0][c]=grid[0][c]+dp[0][c-1];

		for(int r=1;r<3;r++)
			dp[r][0]=grid[r][0]+dp[r-1][0];

		for(int r=1;r<3;r++){
			for(int c=1;c<3;c++){
				dp[r][c]=Math.min(dp[r-1][c], dp[r][c-1])+grid[r][c];
			}
		}

		return dp[2][2];
	}
}