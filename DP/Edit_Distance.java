import java.util.*;

class Edit_Distance{
	static Scanner sc = new Scanner(System.in);
	static int n,m,inf=(int)1e9;
	static int memopad[][];
	public static void main(String[] args) {
		n=sc.nextInt();String ip=sc.next();
		m=sc.nextInt();String op=sc.next();

		memopad=new int[n+1][m+1];
		for(int[] row : memopad)
			Arrays.fill(row,-1);

		System.out.println(top_down(ip,0,op,0));
		System.out.println(bottom_up(ip,op));
	}

	static int top_down(String ip,int i,String op,int j){
		if(i==n && j==m)
			return 0;

		if(i==n)
			return 1+top_down(ip,i,op,j+1);

		if(j==m)
			return 1+top_down(ip,i+1,op,j);

		if(memopad[i][j]!=-1)
			return memopad[i][j];

		int q1=inf,q2=inf,q3=inf,q=inf;

		if(ip.charAt(i)==op.charAt(j))
			q=0+top_down(ip,i+1,op,j+1);
		//Replace
	    q1=1+top_down(ip,i+1,op,j+1);

		//Del
		q2=1+top_down(ip,i+1,op,j);

		//insert
		q3=1+top_down(ip,i,op,j+1);

		memopad[i][j]=Math.min(q,Math.min(q1, Math.min(q2, q3)));

		return memopad[i][j];
	}

	static int bottom_up(String ip,String op){
		int[][] dp=new int[n+1][m+1];

		//fill row for empty string
		for(int i=1;i<=n;i++)
			dp[i][0]=1+dp[i-1][0];

		//fill column for empty string
		for(int j=1;j<=m;j++)
			dp[0][j]=1+dp[0][j-1];

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				//replace
				int q1=dp[i-1][j-1];

				//delete
				int q2=dp[i][j-1];

				//insert
				int q3=dp[i-1][j];

				dp[i][j]=Math.min(q1, Math.min(q2, q3));

				if(ip.charAt(i-1)!=op.charAt(j-1))
					dp[i][j]+=1;
			}
		}

		return dp[n][m];
	}
}