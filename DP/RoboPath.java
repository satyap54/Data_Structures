//You are given dimensions of a grid and also the co-ord of boxes which are blocked
//Your robot can move right or down
//Find no. of ways to reach the last box

import java.util.*;

class RoboPath{
	static Scanner sc = new Scanner(System.in);
	static int dp[][],MOD=(int)1e9+7;

	public static int main(String[] args) {
		int m=sc.nextInt(),n=sc.nextInt(),t=sc.nextInt();
		dp=new int[m+1][n+1];

		while(t-- >0){
			int x=sc.nextInt(),y=sc.nextInt();
			dp[x-1][y-1]=-1;
		}

		//Fill up rows
		for(int i=0;i<m;i++){
			if(dp[i][0]==-1)
				break;

			dp[i][0]=1;//There's only one way to reach any cell in the first column
		}

		//Fill up columns
		for(int i=0;i<n;i++){
			if(dp[0][i]==-1)
				break;

			dp[0][i]=1;
		}

		//When the last box is blocked then there's no way to reach the end
		if(dp[m-1][n-1]==-1)
			return 0;


		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){

				//If this cell is blocked, leave it
				if(dp[i][j]==-1)
					continue;

				if(dp[i-1][j]!=-1)
					dp[i][j]=dp[i-1][j]%MOD;

				if(dp[i][j-1]!=-1)
					dp[i][j]=(dp[i][j]+dp[i][j-1])%MOD;
			}
		}
		System.out.println(dp[m-1][n-1]);

		return 1;
	}
}