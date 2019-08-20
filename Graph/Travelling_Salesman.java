import java.util.*;

class Travelling_Salesman{

	static int n,graph[][],dp[][],VISITED_ALL;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		n=sc.nextInt();
		graph=new int[n][n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				graph[i][j]=sc.nextInt();
		}

		int pos_comb=(int)Math.pow(2,n);
		dp=new int[pos_comb][n];
		for(int row[] : dp)
			Arrays.fill(row,-1);

		VISITED_ALL=pos_comb-1;
	}

	static int tsp(int mask,int pos){
		if(mask==VISITED_ALL)
			return graph[pos][0];

		if(dp[mask][pos]!=-1)
			return dp[mask][pos];

		int ans=Integer.MAX_VALUE;

		for(int i=0;i<n;i++){
			//go to unvisited cities
			int check=mask&(1<<i);
			if(check==0){
				int new_mask=mask|(1<<i);
				int new_ans=graph[pos][i]+tsp(new_mask,i);
				ans=Math.min(new_ans, ans);
			}
		}

		dp[mask][pos]=ans;
		return ans;
	}
}