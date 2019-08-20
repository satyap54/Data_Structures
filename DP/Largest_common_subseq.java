import java.util.*;

class Largest_common_subseq{
	static Scanner sc = new Scanner(System.in);
	static int memopad[][];
	public static void main(String[] args) {
		int m=sc.nextInt();
		char[] x=new char[m];
		String s=sc.next();
		x=s.toCharArray();

		int n=sc.nextInt();
		char[] y=new char[n];
		s=sc.next();
		y=s.toCharArray();

		int[][] dp=new int[m+1][n+1];

		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				int q=0;

				if(x[i-1]==y[j-1]){
					q=1+dp[i-1][j-1];
				}
				else
					q=Math.max(dp[i-1][j], dp[i][j-1]);

				dp[i][j]=q;
			}
		}

		System.out.println(dp[m][n]);

		memopad=new int[m][n];
		for(int row[] : memopad)
			Arrays.fill(row,-1);
		System.out.println(LCS(x,y,m,n,0,0));
	}

	static int LCS(char x[],char y[],int m,int n,int i,int j){
		if(i==m || j==n)
			return 0;

		if(memopad[i][j]!=-1)
			return memopad[i][j];

		if(x[i]==y[j])
			return 1+LCS(x,y,m,n,i+1,j+1);

		memopad[i][j]=Math.max(LCS(x,y,m,n,i+1,j), LCS(x,y,m,n,i,j+1));

		return memopad[i][j];
	}
}