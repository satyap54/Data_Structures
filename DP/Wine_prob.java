import java.util.*;

class Wine_prob{
	static Scanner sc = new Scanner(System.in);
	static int arr[],memopad[][];

	public static void main(String[] args) {
		int n=sc.nextInt();
		arr=new int[n]; memopad=new int[n][n];
		for(int[] row :memopad)
			Arrays.fill(row,-1);

		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		System.out.println(top_down(0,n-1,1));	
		System.out.println(bottom_up(n));
	}

	static int top_down(int be,int end,int year){
		if(be>end)
			return 0;

		if(memopad[be][end]!=-1)
			return memopad[be][end];

		int q1=arr[be]*year+top_down(be+1,end,year+1);
		int q2=arr[end]*year+top_down(be,end-1,year+1);

		memopad[be][end]=Math.max(q1,q2);
		return memopad[be][end];
	}

	static int bottom_up(int n){
		int[][] dp=new int[n][n];
		int year=n;

		for(int i=0;i<n;i++)
			dp[i][i]=year*arr[i];
		year--;

		for(int len=2;len<=n;len++){
			int srt=0,end=n-len-1;

			while(srt<=end){
				int end_window=srt+len-1;
				dp[srt][end_window]=Math.max(arr[srt]*year+dp[srt+1][endwindow], arr[end_window]*year+dp[srt][end_window-1]);
				srt++;
			}

			year--;
		}
		return dp[0][n-1];
	}
}